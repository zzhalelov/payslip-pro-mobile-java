package com.example.payslippro;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private EditText editTextGross;
    private TextView textViewResult;
    private TextView textViewOpv;
    private TextView textViewVosms;
    private TextView textViewIpn;
    Button button;
    RadioButton radioButtonWithDeduction;
    RadioButton radioButtonWithoutDeduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextGross = findViewById(R.id.editTextGross);
        textViewResult = findViewById(R.id.textViewResult);
        textViewOpv = findViewById(R.id.textViewOpv);
        textViewVosms = findViewById(R.id.textViewVosms);
        textViewIpn = findViewById(R.id.textViewIpn);
        button = findViewById(R.id.button);

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
            String grossStr = editTextGross.getText().toString();
            if (grossStr.isEmpty()) {
                textViewResult.setText("Введи числовое значение");
                textViewResult.setTextColor(0xFF800000);
            } else {
                if (!radioButtonWithDeduction.isChecked() && !radioButtonWithoutDeduction.isChecked()) {
                    textViewResult.setText("Установи порядок применения стандартного вычета ИПН (с вычетом / без вычета)");
                } else {
                    int gross = Integer.parseInt(grossStr);
                    FromGrossToNetWithDeduction fromGrossToNetWithDeduction = new FromGrossToNetWithDeduction();
                    int result = fromGrossToNetWithDeduction.calculateFromGrossToNet(gross);
                    int opv = fromGrossToNetWithDeduction.calculateOpv(gross);
                    int vosms = fromGrossToNetWithDeduction.calculateVosms(gross);
                    int ipn = fromGrossToNetWithDeduction.calculateIpn(gross);
                    textViewResult.setText("К получению на руки: " + result);
                    textViewOpv.setText("ОПВ: " + opv);
                    textViewVosms.setText("ВОСМС: " + vosms);
                    textViewIpn.setText("ИПН: " + ipn);
                }
            }
        } else {
            String grossStr = editTextGross.getText().toString();
            if (grossStr.isEmpty()) {
                textViewResult.setText("Введи числовое значение");
                textViewResult.setTextColor(0xFF800000);
            } else {
                if (!radioButtonWithDeduction.isChecked() && !radioButtonWithoutDeduction.isChecked()) {
                    textViewResult.setText("Установи порядок применения стандартного вычета ИПН (с вычетом / без вычета)");
                } else {
                    int gross = Integer.parseInt(grossStr);
                    FromGrossToNetWithoutDeduction fromGrossToNetWithoutDeduction = new FromGrossToNetWithoutDeduction();
                    int result = fromGrossToNetWithoutDeduction.calculateFromGrossToNet(gross);
                    int opv = fromGrossToNetWithoutDeduction.calculateOpv(gross);
                    int vosms = fromGrossToNetWithoutDeduction.calculateVosms(gross);
                    int ipn = fromGrossToNetWithoutDeduction.calculateIpn(gross);
                    textViewResult.setText("К получению на руки: " + result);
                    textViewOpv.setText("ОПВ: " + opv);
                    textViewVosms.setText("ВОСМС: " + vosms);
                    textViewIpn.setText("ИПН: " + ipn);
                }
            }
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(button.getWindowToken(), 0);
    }

    public void returnButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}