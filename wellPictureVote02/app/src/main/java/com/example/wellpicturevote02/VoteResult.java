package com.example.wellpicturevote02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class VoteResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_result);

        Intent intent = getIntent();        //인탠트 객체 들고오기
        int[] voteResult = intent.getIntArrayExtra("VoteCount");        //투표수 들고오기
        String[] imageName = intent.getStringArrayExtra("ImageName");   //이미지 이름 들고오기

        TextView tv[] = new TextView[imageName.length];     //이름 배열로 저장
        RatingBar rbar[] = new RatingBar[imageName.length]; //래이팅바 배열로 저장

        Integer tvId[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                        R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        Integer rbarId[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5,
                R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        for(int i = 0; i < voteResult.length; i++){
            tv[i] = (TextView) findViewById(tvId[i]);       //가져온 이미지 이름 넣어주기
            tv[i].setText(imageName[i]);
            rbar[i] = (RatingBar) findViewById(rbarId[i]);  //가져온 결과값 별 칠해주기
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();       //투표 화면으로 돌아가기
            }
        });
    }
}