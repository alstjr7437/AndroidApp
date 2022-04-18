package com.example.test001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class VoteR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_r);

        Intent intent = getIntent();        //인탠트 객체 들고오기
        int[] voteResult = intent.getIntArrayExtra("vote");        //투표수 들고오기
        String[] imageName = intent.getStringArrayExtra("name");   //이미지 이름 들고오기
        ListView listView=(ListView) findViewById(R.id.listV);
        mAdapter adapter = new mAdapter();
        listView.setAdapter(adapter);
        int imageD[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};


        for (int i = 0; i < voteResult.length; i++) {
            adapter.addItem(imageD[i], imageName[i], voteResult[i]);
        }


        Button btnReturn = (Button) findViewById(R.id.button2);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();       //투표 화면으로 돌아가기
            }
        });
    }


}