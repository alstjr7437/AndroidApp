package com.example.test01;

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

        int[] vote = new int[9];
        ImageView[] img = new ImageView[9];
        int[] imgId = {R.id.imageView, R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5,
                R.id.imageView6, R.id.imageView7, R.id.imageView8, R.id.imageView9};
        String[] imgN = {"pic1", "pic2", "pic3", "pic4", "pic5", "pic6", "pic7", "pic8", "pic9"};

        for(int i = 0; i < imgId.length; i++){
            final int index = i;
            img[index] = (ImageView) findViewById(imgId[index]);
            img[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vote[index]++;
                    Toast.makeText(MainActivity.this, imgN[index] + "의 투표 수는" + vote[index] + "횟수 입니다.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), voteR.class);
                intent.putExtra("name",imgN);
                intent.putExtra("vote",vote);

                startActivity(intent);
            }
        });
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), calC.class);
                startActivity(intent2);
            }
        });
    }
}