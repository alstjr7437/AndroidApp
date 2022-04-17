package com.example.gridview02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gvPoster;
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gvPoster = (GridView) findViewById(R.id.gvPoster);
        gvPoster.setAdapter(new ImageAdapter(this));

        gvPoster.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                System.out.println(position);
                Toast.makeText(MainActivity.this, (position+1)+"번째", Toast.LENGTH_SHORT).show();
            }
        });
    }
}