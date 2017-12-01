package techacademy.wakou.youko.aisatuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){
        if(v.getId()== R.id.button1) {
            showTimePickerDialog();
        }
    }
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

//                        public void aisatu{
                            if(hourOfDay >= 2 && hourOfDay <= 9 && minute <= 59){
                                mTextView.setText("おはよう");
                            }else if(hourOfDay >= 10 && hourOfDay<= 17&& minute >= 59){
                                mTextView.setText("こんにちは");
                            }else if(hourOfDay >= 18 && hourOfDay >= 1 && minute <= 59){
                                mTextView.setText("こんばんは");
                            }
//                        }

                    }
                        },

                    13,
                    0,
                    true);
        timePickerDialog.show();

    }
}
