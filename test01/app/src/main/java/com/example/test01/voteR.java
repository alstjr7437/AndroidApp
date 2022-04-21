package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class voteR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_r);

        Intent intent = getIntent();
        int[] pic = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9 };
        int[] vote = intent.getIntArrayExtra("vote");
        String[] name = intent.getStringArrayExtra("name");

        ListView listV = (ListView) findViewById(R.id.listV);
        mAdapter adapter = new mAdapter();
        listV.setAdapter(adapter);

        for(int i = 0; i < pic.length; i++){
            adapter.addItem(pic[i], name[i], vote[i]);
        }
    }
}