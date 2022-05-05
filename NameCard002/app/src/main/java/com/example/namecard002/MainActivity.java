package com.example.namecard002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText etName, etTel, etEmail;
    String name, tel_no, e_mail;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.txtName);
        etTel = (EditText) findViewById(R.id.txtTelNo);
        etEmail = (EditText) findViewById(R.id.txtEmail);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        Button btnDelete = (Button) findViewById(R.id.btnDelete);

        //추가
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
                tel_no = etTel.getText().toString();
                e_mail = etEmail.getText().toString();

                dataInsert(name, tel_no, e_mail);
            }
        });
        //조회
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSearch();
            }
        });
        //수정
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataUpdate();
            }
        });
        //삭제
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataDelete();
            }
        });
        
    }

    //추가 메서드
    public void dataInsert(String name, String tel_no, String e_mail){
        new Thread(){
            public void run(){
                try{
                    URL setURL = new URL("Http://10.0.2.2/insert.php/");
                    HttpURLConnection http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name).append("/").append(tel_no).append("/").append(e_mail).append("/");
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(),"UTF-8");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
                    final BufferedReader reader = new BufferedReader(tmp);
                    while(reader.readLine() != null){
                        System.out.println(reader.readLine());
                    }
                } catch(Exception e){
                    Log.e("dataInsert()","지정 에러 발생", e);
                }
            }
        }.start();
    }
    
    //조회 메서드
    public void dataSearch(){
        new Thread(){
            public void run(){
                try{
                    name = etName.getText().toString();

                    URL setURL = new URL("Http://10.0.2.2/search.php/");
                    HttpURLConnection http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name);
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(),"UTF-8");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
                    final BufferedReader reader = new BufferedReader(tmp);
                    StringBuilder builder = new StringBuilder();
                    String str;

                    while((str = reader.readLine()) != null){
                        builder.append(str + "\n");
                    }
                    String resultData = builder.toString();
                    final String[] sResult = resultData.split("/");
                    handler.post(new Runnable(){
                        public void run() {
                            Toast.makeText(MainActivity.this, sResult[0]+"\n"+sResult[1]+"\n"+sResult[2],Toast.LENGTH_SHORT).show();
                            etName.setText(sResult[0]);
                            etTel.setText(sResult[1]);
                            etEmail.setText(sResult[2]);
                        }
                    });
                } catch(Exception e){
                    Log.e("dataSearch()","지정 에러 발생", e);
                }
            }
        }.start();
    }

    //수정 메서드
    public void dataUpdate(){
        new Thread(){
            public void run(){
                try{
                    name = etName.getText().toString();
                    tel_no = etTel.getText().toString();
                    e_mail = etEmail.getText().toString();

                    URL setURL = new URL("Http://10.0.2.2/update.php/");
                    HttpURLConnection http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name).append("/").append(tel_no).append("/").append(e_mail).append("/");
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(),"UTF-8");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
                    final BufferedReader reader = new BufferedReader(tmp);
                    StringBuilder builder = new StringBuilder();
                    String str, result;

                    while((str = reader.readLine()) != null){
                        builder.append(str + "\n");
                    }
                    result = builder.toString();
                    String[] sResult = result.split("/");

                    handler.post(new Runnable(){
                        public void run() {
                            Toast.makeText(MainActivity.this, name + "의 정보 수정",Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch(Exception e){
                    Log.e("dataUpdate()","지정 에러 발생", e);
                }
            }
        }.start();
    }

    //삭제 메서드
    public void dataDelete(){
        new Thread(){
            public void run(){
                try{
                    name = etName.getText().toString();

                    URL setURL = new URL("Http://10.0.2.2/delete.php/");
                    HttpURLConnection http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name);
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(),"UTF-8");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
                    final BufferedReader reader = new BufferedReader(tmp);
                    StringBuilder builder = new StringBuilder();
                    String result = builder.toString();
                    final String[] sResult = result.split("/");

                    handler.post(new Runnable(){
                        public void run() {
                            Toast.makeText(MainActivity.this, name + "의 정보 삭제",Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch(Exception e){
                    Log.e("dataDelete()","지정 에러 발생", e);
                }
            }
        }.start();
    }
}