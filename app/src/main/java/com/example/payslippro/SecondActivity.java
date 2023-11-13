package com.example.payslippro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private EditText editTextGross;
    private TextView textViewResult;

    RadioButton radioButtonWithDeduction;
    RadioButton radioButtonWithoutDeduction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextGross = findViewById(R.id.editTextGross);
        textViewResult = findViewById(R.id.textViewResult);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioButtonWithDeduction = findViewById(R.id.radioButtonWithDeduction);
        radioButtonWithoutDeduction = findViewById(R.id.radioButtonWithoutDeduction);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonWithDeduction){
                    textViewResult.setText("С вычетом");
                } else if (checkedId == R.id.radioButtonWithoutDeduction) {
                    textViewResult.setText("Без вычета");
                }
            }
        });
    }

    public void clickButton(View view) {
        String grossStr = editTextGross.getText().toString();
        int gross = Integer.parseInt(grossStr);
        FromGrossToNetWithDeduction fromGrossToNetWithDeduction = new FromGrossToNetWithDeduction();
        int result = fromGrossToNetWithDeduction.calculateFromGrossToNet(gross);
        textViewResult.setText(result + "");
    }
}