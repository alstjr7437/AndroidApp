package com.example.customlistview002;

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
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.human1), "친구","01030247437");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.human2), "어머니","01029493349");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.human3), "아버지","01045824862");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.human4), "동료","01055556666");

        //리스트뷰 누를 때 이벤트 처리
        listview.setOnItemClickListener(new Adapte      rView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String title = item.getTitle();
                String telNo = item.getDescription();
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();

                Uri uri = Uri.parse("tel: "+ telNo);
                Intent call =new Intent(Intent.ACTION_DIAL, uri);
                startActivity(call);
            }
        });
    }
}