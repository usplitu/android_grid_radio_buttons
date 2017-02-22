package design.material.immersiveimagesictskills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
  ImageView imageView;

  RadioButton centerBtn;
  RadioButton fitEndBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imageView = (ImageView) findViewById(R.id.imageView);

    centerBtn = (RadioButton) findViewById(R.id.centerBtn);
    fitEndBtn = (RadioButton) findViewById(R.id.fitEndBtn);

    centerBtn.setOnClickListener(this);
    fitEndBtn.setOnClickListener(this);

    centerBtn.setChecked(true);

    imageView.setOnClickListener(this);

  }

  /**
   * If radio button, not that in focus, is pressed
   * then return that button view, else null.
   *
   * @param view The most recently clicked radio button.
   * @return The clicked radio button if different to view param.
   */
  public RadioButton getSelectedRadio(View view) {
    RadioButton[] btns = {centerBtn, fitEndBtn};
    for (RadioButton radioButton : btns) {
      if (radioButton.isChecked() && radioButton != view) {
        return radioButton;
      }
    }
    return null;
  }

  @Override
  public void onClick(View view) {

    // Determine if a radio button clicked and implement handler
    RadioButton checkedRadio = view instanceof RadioButton ? getSelectedRadio(view) : null;
    if (checkedRadio != null) {
      // Untick all buttons except that in focus.
      if (checkedRadio != view) {
        checkedRadio.setChecked(false);
      }
      String radioId = ((RadioButton) view).getText().toString();
      switch (radioId) {
        case "CENTER":
          imageView.setScaleType(ImageView.ScaleType.CENTER);
          break;
        case "FIT_END":
          imageView.setScaleType(ImageView.ScaleType.FIT_END);
          break;
      }
    }
    else {
      // Other view handlers, such as clicking on the ImageView
    }
  }
}
