 package com.example.customtest01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ListView;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listview;
        ListViewAdapter adapter;

        //adapter 생성
        adapter = new ListViewAdapter();

        //리스트 뷰 들고오기 및 adapter달기
        listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);

        //아이템 추가하기
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background), "친구","01030247437");
       }
}