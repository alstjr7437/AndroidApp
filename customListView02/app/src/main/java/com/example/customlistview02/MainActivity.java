package com.example.customlistview02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        //아이템 추가하기
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie1), "어메이징 스파이더맨","외국 영화(포스터는 다른것)");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie2), "청년 경찰","한국영화(포스터는 다른것)");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie3), "닥터스트레인지","외국 영화(포스터는 다른것)");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie4), "타짜","한국영화(포스터는 다른것)");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie5), "신세계","한국영화(포스터는 다른것)");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie6), "어벤져스","외국 영화(포스터는 다른것)");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie7), "아이언맨","외국 영화(포스터는 다른것)");

        //리스트뷰 누를 때 이벤트 처리
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String title = item.getTitle();
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                /*
                //영화 화면 나오게 하기
                Uri uri = Uri.parse("https://movie.naver.com/movie/bi/mi/basic.naver?code=66823");
                Intent intentWeb = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intentWeb);
                */
            }
        });
    }
}