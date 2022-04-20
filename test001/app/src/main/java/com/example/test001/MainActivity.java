package com.example.test001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //투표 수를 저장할 배열
        final int vote[]  = new int[9];
        //이미지를 가져올 배열
        ImageView image[] = new ImageView[9];
        //이미지 아이디를 가져와 반복문을 위한 배열
        int imageId[] = {R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5, R.id.imageView6, R.id.imageView7,
                        R.id.imageView8, R.id.imageView9, R.id.imageView10};
        //이미지 이름을 저장할 배열
        String imageName[] = {"그림1", "그림2", "그림3", "그림4", "그림5", "그림6", "그림7", "그림8", "그림9"};
        //반복문을 이용한 이미지를 붙이고 투표를 위한 반복문
        for(int i = 0; i < imageId.length; i++){
            final int index = i;
            image[index] =(ImageView)findViewById(imageId[i]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vote[index]++;
                    Toast.makeText(getApplicationContext(), imageName[index] + "의 총 투표는" + vote[index] + "입니다.",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        //결과 화면으로 넘어갈 버튼
        Button btnR = (Button) findViewById(R.id.button);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인탠드를 이용한 화면 옮겨가기
                Intent intent = new Intent(getApplicationContext(), VoteR.class);
                //인탠드를 넘어가는 화면에 이름과 투표수 받아가기
                intent.putExtra("name", imageName);
                intent.putExtra("vote", vote);
                //intent 실행
                startActivity(intent);
            }
        });
    }
}