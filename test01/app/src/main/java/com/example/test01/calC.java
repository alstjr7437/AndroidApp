package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_c);

        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        TextView finalTvResult = tvResult;
        String num1, num2;
        int result;
        double result2;

        EditText etNum1 = (EditText)findViewById(R.id.etNum);
        EditText etNum2 = (EditText)findViewById(R.id.etNum2);

        Button btnPlus = (Button)findViewById(R.id.btnPlus);
        Button btnMinus = (Button)findViewById(R.id.btnMinus);
        Button btnMul = (Button)findViewById(R.id.btnMul);
        Button btnDe = (Button)findViewById(R.id.btnDe);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = etNum1.getText().toString();
                String num2 = etNum2.getText().toString();
                int result = Integer.parseInt(num1) + Integer.parseInt(num2);
                finalTvResult.setText("계산결과 : " + result);
            }
        });
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = etNum1.getText().toString();
                String num2 = etNum2.getText().toString();
                int result = Integer.parseInt(num1) - Integer.parseInt(num2);
                finalTvResult.setText("계산결과 : " + result);
            }
        });
        btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = etNum1.getText().toString();
                String num2 = etNum2.getText().toString();
                int result = Integer.parseInt(num1) * Integer.parseInt(num2);
                finalTvResult.setText("계산결과 : " + result);
            }
        });
        btnDe = (Button) findViewById(R.id.btnDe);
        btnDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = etNum1.getText().toString();
                String num2 = etNum2.getText().toString();
                double result2 = (double) (Double.parseDouble(num1) / Double.parseDouble(num2));
                finalTvResult.setText("계산결과 : " + result2);
            }
        });
        tvResult = (TextView) findViewById(R.id.textView);
    }
}