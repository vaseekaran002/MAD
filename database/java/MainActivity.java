package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button creatButton = (Button) findViewById(R.id.create);
        final Button insertButton = (Button) findViewById(R.id.insert);
        final Button retrieveButton = (Button) findViewById(R.id.retrieve);


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insertIntent = new Intent(MainActivity.this,InsertActivity.class);
                startActivity(insertIntent);
            }
        });

        retrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retrieveIntent = new Intent(MainActivity.this,RetrieveActivity.class);
                startActivity(retrieveIntent);
            }
        });

    }
}