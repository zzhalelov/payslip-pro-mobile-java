package com.example.payslippro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private EditText editTextGross;
    private TextView textViewResult;
    private RadioButton radioButton1;
    private RadioButton radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextGross = findViewById(R.id.editTextGross);
        textViewResult = findViewById(R.id.textViewResult);
        radioButton1 = findViewById(R.id.radioButtonWithDeduction);
        radioButton2 = findViewById(R.id.radioButtonWithoutDeduction);
    }

    public void clickButton(View view) {
            String grossStr = editTextGross.getText().toString();
            int gross = Integer.parseInt(grossStr);
            FromGrossToNetWithDeduction fromGrossToNetWithDeduction = new FromGrossToNetWithDeduction();
            int result = fromGrossToNetWithDeduction.calculateFromGrossToNet(gross);
            textViewResult.setText(result + "");
    }
}