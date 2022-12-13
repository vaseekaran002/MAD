package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lunch extends AppCompatActivity {

    TextView sheet2;
    ImageView back;
    Button download;
    private DBHandler dbHandler;
    public String s;
    private String filepath = "MyFileStorage";
    private String filename = "LunchRecipes.txt";
    File file;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch);

        sheet2 = (TextView) findViewById(R.id.sheet2);
        back = (ImageView) findViewById(R.id.iback);
        download = (Button) findViewById(R.id.bldownload);

        dbHandler = new DBHandler(Lunch.this);
        s = dbHandler.getRecipes("LUNCH");
        sheet2.setText(s);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save(s);
            }
        });
    }

    public void Save(String recipes) {
        file = new File(getExternalFilesDir(filepath), filename);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(recipes.getBytes());
            fos.close();
            Toast.makeText(getApplicationContext(),"Recipes are Successfully Downloaded!",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goBack() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
