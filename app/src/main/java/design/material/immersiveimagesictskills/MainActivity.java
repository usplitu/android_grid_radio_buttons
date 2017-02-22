package design.material.immersiveimagesictskills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{

  @BindView(R.id.imageView) ImageView imageView;

  @BindView(R.id.centerBtn) RadioButton centerBtn;
  @BindView(R.id.fitEndBtn) RadioButton fitEndBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    centerBtn.setChecked(true);

  }

  /**
   * If radio button, not the currently clicked, is pressed
   * then return that button view, else null.
   * @param view The currently clicked radio button
   * @return The clicked radio button, if not the currently selected.
   */
    public RadioButton getSelectedRadio(View view) {
      RadioButton [] btns = {centerBtn, fitEndBtn};
      for (RadioButton radioButton : btns) {
        if (radioButton.isChecked() && radioButton != view) {
          return radioButton;
        }
      }
      return null;
    }

  @OnClick({R.id.centerBtn, R.id.fitEndBtn})
  public void clickRadioButton(RadioButton view) {

    // Check to see what is clicked
    RadioButton checkedRadio = getSelectedRadio(view);
    if (checkedRadio != null && checkedRadio != view) {
      checkedRadio.setChecked(false);
    }

    switch(view.getText().toString()) {
      case "CENTER":
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        break;
      case "FIT_END":
          imageView.setScaleType(ImageView.ScaleType.FIT_END);
        break;
     }


  }
}
