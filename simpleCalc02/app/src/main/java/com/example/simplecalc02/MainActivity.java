package com.example.simplecalc02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btnPlus, btnMinus, btnMultiply, btnDevide;
    TextView textResult;
    Button[] numBtn = new Button[10];
    int[] numBtnId = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4, R.id.btnNum5,
                    R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};
    int result;         //결과값 저장
    double result2;     //결과값 저장(나누기)
    String num1, num2;  //계산을 위한 숫자 받아오기
    int i;              //반복문을 위한 i


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //text 가져오기
        etNum1 = (EditText  )findViewById(R.id.etNum1);
        etNum2 = (EditText)findViewById(R.id.etNum2);

        //자판 버튼 코드
        for(i = 0; i < numBtnId.length; i++) {          //변수 배열에 버튼아이디 넣기 위한 for 반북문
            numBtn[i] = (Button)findViewById(numBtnId[i]);
            final int index = i;                        //파이널을..?

            numBtn[index].setOnClickListener(new View.OnClickListener() {       //버튼 클릭시 나오는것들
                @Override
                public void onClick(View view) {
                    if(etNum1.isFocused() == true){
                        num1 = etNum1.getText().toString() + numBtn[index].getText().toString();
                        etNum1.setText(num1);

                    } else if(etNum2.isFocused() == true){
                        num2 = etNum2.getText().toString() + numBtn[index].getText().toString();
                        etNum2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),"먼저 에디트 텍스트를 입력하세요",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        //연산 버튼 계산코드
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산결과 : " + result);
            }
        });
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산결과 : " + result);
            }
        });
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산결과 : " + result);
            }
        });
        btnDevide = (Button) findViewById(R.id.btnDevide);
        btnDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                //result2 = Double.valueOf(num1) / Double.valueOf(num2);
                result2 = (double) (Double.parseDouble(num1) / Double.parseDouble(num2));
                textResult.setText("계산결과 : " + result2);
            }
        });
        
        //결과 text 가져오기
        textResult = (TextView) findViewById(R.id.textResult);
    }
}