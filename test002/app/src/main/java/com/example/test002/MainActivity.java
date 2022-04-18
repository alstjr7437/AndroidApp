package com.example.test002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button[] numBtn = new Button[10];
    int[] numBtnId = {R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8
                    , R.id.button9};
    String num1, num2;
    int result;
    double result2;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNum1 = (EditText)findViewById(R.id.etNum1);
        EditText etNum2 = (EditText)findViewById(R.id.etNum2);

        Button btnPlus = (Button)findViewById(R.id.btnPlus);
        Button btnMinus = (Button)findViewById(R.id.btnMinus);
        Button btnMul = (Button)findViewById(R.id.btnMul);
        Button btnDe = (Button)findViewById(R.id.btnDe);

        for(i = 0; i < numBtnId.length; i++){
            numBtn[i] = (Button)findViewById(numBtnId[i]);
            final int index = i;

            numBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(etNum1.isFocused() == true){
                        num1 = etNum1.getText().toString() + numBtn[index].getText().toString();
                        etNum1.setText(num1);
                    } else if(etNum2.isFocused() == true) {
                        num2 = etNum2.getText().toString() + numBtn[index].getText().toString();
                        etNum2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "에디트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                tvResult.setText("계산결과 : " + result);
            }
        });
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tvResult.setText("계산결과 : " + result);
            }
        });
        btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                tvResult.setText("계산결과 : " + result);
            }
        });
        btnDe = (Button) findViewById(R.id.btnDe);
        btnDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                result2 = (double) (Double.parseDouble(num1) / Double.parseDouble(num2));
                tvResult.setText("계산결과 : " + result2);
            }
        });
        tvResult = (TextView) findViewById(R.id.textView);
    }
}