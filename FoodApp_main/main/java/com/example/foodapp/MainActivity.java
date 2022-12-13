package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DBHandler(MainActivity.this);
        dbHandler.populateTable();

        b1 = (Button) findViewById(R.id.bbreakfast);
        b2 = (Button) findViewById(R.id.blunch);
        b3 = (Button) findViewById(R.id.bsnacks);
        b4 = (Button) findViewById(R.id.bdinner);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBreakfastPage();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLunchPage();
            }
        });
    }

    public void openBreakfastPage() {
        Intent intent = new Intent(this, Breakfast.class);
        startActivity(intent);
    }

    public void openLunchPage() {
        Intent intent = new Intent(this, Lunch.class);
        startActivity(intent);
    }
}