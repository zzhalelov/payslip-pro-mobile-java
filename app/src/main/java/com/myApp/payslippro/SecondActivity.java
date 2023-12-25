package com.myApp.payslippro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    private EditText editTextGross;
    private TextView textViewResult;
    private TextView textViewOpv;
    private TextView textViewVosms;
    private TextView textViewIpn;
    private Button button;
    RadioButton radioButtonWithDeduction;
    RadioButton radioButtonWithoutDeduction;
    Spinner spinnerResident;
    private Button saveButton;

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
        spinnerResident = findViewById(R.id.spinnerResident);
        saveButton = findViewById(R.id.saveButton);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioButtonWithDeduction = findViewById(R.id.radioButtonWithDeduction);
        radioButtonWithoutDeduction = findViewById(R.id.radioButtonWithoutDeduction);
        radioGroup.clearCheck();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToExcel();
            }
        });

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
                    String resultStr = String.format(Locale.CANADA_FRENCH, "%,d", result);
                    String opvStr = String.format(Locale.CANADA_FRENCH, "%,d", opv);
                    String vosmsStr = String.format(Locale.CANADA_FRENCH, "%,d", vosms);
                    String ipnStr = String.format(Locale.CANADA_FRENCH, "%,d", ipn);
                    textViewResult.setText("К получению на руки: " + resultStr);
                    textViewOpv.setText("ОПВ: " + opvStr);
                    textViewVosms.setText("ВОСМС: " + vosmsStr);
                    textViewIpn.setText("ИПН: " + ipnStr);
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
                    String resultStr = String.format(Locale.CANADA_FRENCH, "%,d", result);
                    String opvStr = String.format(Locale.CANADA_FRENCH, "%,d", opv);
                    String vosmsStr = String.format(Locale.CANADA_FRENCH, "%,d", vosms);
                    String ipnStr = String.format(Locale.CANADA_FRENCH, "%,d", ipn);
                    textViewResult.setText("К получению на руки: " + resultStr);
                    textViewOpv.setText("ОПВ: " + opvStr);
                    textViewVosms.setText("ВОСМС: " + vosmsStr);
                    textViewIpn.setText("ИПН: " + ipnStr);
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

    public void saveDataToExcel() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("DataSheet");

        String[] data = {"Заголовок 1", "Заголовок 2", "Заголовок 3"};

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < data.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(data[i]);
        }

        String[] rowData = {"Значение 1", "Значение 2", "Значение 3"};

        Row dataRow = sheet.createRow(1);
        for (int i = 0; i < rowData.length; i++) {
            Cell cell = dataRow.createCell(i);
            cell.setCellValue(rowData[i]);
        }

        try {
            File file = new File(Environment.getExternalStorageDirectory(), "example.xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}