package com.example.wellpicturevote02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
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

        final int voteCount[] = new int[9];         //투표 횟수를 저장하는 배열
        for(int i = 0; i < 9; i++){                 //투표 횟수를 0으로 초기화 해주는 반복문
            voteCount[i] = 0;
        }
        ImageView image[] = new ImageView[9];       //이미지를 들고오기 위한 배열
        int imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,          //이미지 아이디 들고오기 위한 배열
                        R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양",     //이미지 이름을 넣는 배열
                                    "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};
        for(int i = 0; i < imageId.length; i++) {       //이미지 아이디를 들고오는 반복문
            final int index;
            index = i;
            image[index] = (ImageView)findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;         //누를시 투표 수가 늘어남
                    Toast.makeText(getApplicationContext(), imgName[index] + ": 총 " +           //toast문으로 몇번 투표 했는지 보여줌
                                    voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = (Button) findViewById(R.id.btnResult);       //버튼 클릭시 결과하면 옮겨가기
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VoteResult.class);       //VoteResult파일로 옮겨가기
                intent.putExtra("VoteCount", voteCount);            //VoteCount이름으로 결과 값 저장
                intent.putExtra("ImageName",imgName);               //ImageName이름으로 이미지 이름 저장
                startActivity(intent);                                    //VotResult 파일 실행
            }
        });
    }
}