package sg.edu.rp.c346.id22011505.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

TextView tvNameDisplay;
EditText edtName;
TextView tvMobileDisplay;
EditText edtMobile;
TextView tvSizeDisplay;
EditText edtSize;
DatePicker dp;
TimePicker tp;
RadioGroup rgArea;
RadioButton rbSmoking, rbNonSmoking;

Button btnConfirm;
Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNameDisplay = findViewById(R.id.textViewName);
        edtName = findViewById(R.id.editTextName);
        tvMobileDisplay = findViewById(R.id.textViewNumber);
        edtMobile = findViewById(R.id.editTextNumber);
        tvSizeDisplay = findViewById(R.id.textViewSize);
        edtSize = findViewById(R.id.editTextSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        rgArea = findViewById(R.id.radioGroupArea);
        rbSmoking = findViewById(R.id.radioButtonSmoking);
        rbNonSmoking = findViewById(R.id.radioButtonNonSmoking);
        btnConfirm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String mobile = edtMobile.getText().toString();
                String size = edtSize.getText().toString();

                int hour = tp.getHour();
                int minute = tp.getMinute();

                int Day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();

                String Time;

                if (minute < 10) {
                    Time =  hour + ":" + String.format("%02d", minute);
                } else{
                    Time = "Time is " + hour + ":" + minute;
                }

                String date = Day + "/" + month + "/" + year;

                int checkedRadioId= rgArea.getCheckedRadioButtonId();
                String area = null;
                if(rbSmoking.isChecked()) {
                    String message = "\nName: " + name + "\nMobile Number: " + mobile + "\nGroup Size: " + size + "" +
                            "\nDate: " + date + "\nTime: " + Time + "\nTable: Smoking";
                    Toast confirmedClicked = Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT );
                } else{
                    String message = "\nName: " + name + "\nMobile Number: " + mobile + "\nGroup Size: " + size + "" +
                            "\nDate: " + date + "\nTime: " + Time + "\nTable: Non-Smoking";
                    Toast confirmedClicked = Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT);
                }











            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setText("");
                edtMobile.setText("");
                edtSize.setText("");
                tp.setHour(19);
                tp.setMinute(30);
                dp.updateDate(2020, (1-1), 1);
                rbSmoking.setChecked(false);
                rbNonSmoking.setChecked(false);

            }
        });



    }
}