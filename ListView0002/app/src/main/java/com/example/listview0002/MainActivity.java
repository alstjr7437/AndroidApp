package com.example.listview0002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFruit = (ListView) findViewById(R.id.lvFruit);
        String[] data = {"본인", "어머니", "아버지", "친구1", "친구2", "룸메"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lvFruit.setAdapter(adapter);

        lvFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Name = (String) adapterView.getItemAtPosition(i);
                String telNo = "0";
                if (Name.equals("본인")){
                    telNo = "01030247437";
                } else if (Name.equals("어머니")){
                    telNo = "01029493349";
                } else if (Name.equals("아버지")) {
                    telNo = "01045824862";
                }
                //Toast.makeText(MainActivity.this, telNo , Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("tel:" + telNo);
                Intent call = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(call);

            }
        });
    }
}