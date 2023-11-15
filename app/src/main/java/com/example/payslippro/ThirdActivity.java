package com.example.payslippro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private EditText editTextNet;
    private TextView textViewResult;
    RadioButton radioButtonWithDeduction;
    RadioButton radioButtonWithoutDeduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        editTextNet = findViewById(R.id.editTextGross);
        textViewResult = findViewById(R.id.textViewResult);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioButtonWithDeduction = findViewById(R.id.radioButtonWithDeduction);
        radioButtonWithoutDeduction = findViewById(R.id.radioButtonWithoutDeduction);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButtonWithDeduction) {

            } else if (checkedId == R.id.radioButtonWithoutDeduction) {

            }
        });
    }

    public void clickButton(View view) {
        if (radioButtonWithDeduction.isChecked()) {
            String netStr = editTextNet.getText().toString();
            if (netStr.isEmpty()) {
                textViewResult.setText("Ведите числовое значение");
                textViewResult.setTextColor(0xFF800000);
            } else {
                int net = Integer.parseInt(netStr);
                FromNetToGrossWithDeduction fromNetToGrossWithDeduction = new FromNetToGrossWithDeduction();
                int result = fromNetToGrossWithDeduction.calculateFromNetToGross(net);
                textViewResult.setText(result + " результат");
            }
        } else {
            String netStr = editTextNet.getText().toString();
            if (netStr.isEmpty()) {
                textViewResult.setText("Ведите числовое значение");
                textViewResult.setTextColor(0xFF800000);
            } else {
                int gross = Integer.parseInt(netStr);
                FromNetToGrossWithoutDeduction fromNetToGrossWithoutDeduction = new FromNetToGrossWithoutDeduction();
                int result = fromNetToGrossWithoutDeduction.calculateFromNetToGross(gross);
                textViewResult.setText(result + "");
            }
        }
    }
}