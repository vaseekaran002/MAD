package com.example.graphicsprimitives;

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

        final Button shapesButton = (Button) findViewById(R.id.shapeButton);
        final Button animateButton =(Button) findViewById(R.id.animateButton);
        final Button transformButton = (Button) findViewById(R.id.transformButton);


        shapesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shapeIntent = new Intent(MainActivity.this,ShapesActivity.class);
                startActivity(shapeIntent);
            }
        });

        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent animateIntent = new Intent(MainActivity.this,AnimateActivity.class);
                startActivity(animateIntent);
            }
        });

        transformButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transformIntent = new Intent(MainActivity.this,TransformActivity.class);
                startActivity(transformIntent);
            }
        });

    }
}