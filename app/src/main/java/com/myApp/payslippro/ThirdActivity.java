package com.myApp.payslippro;

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

public class ThirdActivity extends AppCompatActivity {
    private EditText editTextNet;
    private TextView textViewResult;
    private TextView textViewOpv;
    private TextView textViewVosms;
    private TextView textViewIpn;
    private Button button;
    RadioButton radioButtonWithDeduction;
    RadioButton radioButtonWithoutDeduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        editTextNet = findViewById(R.id.editTextGross);
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
            String netStr = editTextNet.getText().toString();
            if (netStr.isEmpty()) {
                textViewResult.setText("Введи числовое значение");
                textViewResult.setTextColor(0xFF800000);
            } else {
                if (!radioButtonWithDeduction.isChecked() && !radioButtonWithoutDeduction.isChecked()) {
                    textViewResult.setText("Установи порядок применения стандартного вычета ИПН (с вычетом / без вычета)");
                } else {
                    int net = Integer.parseInt(netStr);
                    FromNetToGrossWithDeduction fromNetToGrossWithDeduction = new FromNetToGrossWithDeduction();
                    int result = fromNetToGrossWithDeduction.calculateFromNetToGross(net);
                    int opv = fromNetToGrossWithDeduction.calculateOpv(result);
                    int vosms = fromNetToGrossWithDeduction.calculateVosms(result);
                    int ipn = fromNetToGrossWithDeduction.calculateIpn(result);
                    textViewResult.setText("Сумма к начислению: " + result);
                    textViewOpv.setText("ОПВ: " + opv);
                    textViewVosms.setText("ВОСМС: " + vosms);
                    textViewIpn.setText("ИПН: " + ipn);
                }
            }
        } else {
            String netStr = editTextNet.getText().toString();
            if (netStr.isEmpty()) {
                textViewResult.setText("Введи числовое значение");
                textViewResult.setTextColor(0xFF800000);
            } else {
                if (!radioButtonWithDeduction.isChecked() && !radioButtonWithoutDeduction.isChecked()) {
                    textViewResult.setText("Установи порядок применения стандартного вычета ИПН (с вычетом / без вычета)");
                } else {
                    int net = Integer.parseInt(netStr);
                    FromNetToGrossWithoutDeduction fromNetToGrossWithoutDeduction = new FromNetToGrossWithoutDeduction();
                    int result = fromNetToGrossWithoutDeduction.calculateFromNetToGross(net);
                    int opv = fromNetToGrossWithoutDeduction.calculateOpv(result);
                    int vosms = fromNetToGrossWithoutDeduction.calculateVosms(result);
                    int ipn = fromNetToGrossWithoutDeduction.calculateIpn(result);
                    textViewResult.setText("Сумма к начислению: " + result);
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