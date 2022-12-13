package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText fileNameTxt = (EditText) findViewById(R.id.et_name);
        final EditText contentText = (EditText) findViewById(R.id.et_content);
        final Button readBtn = (Button) findViewById(R.id.bt_read);
        final Button writeBtn = (Button) findViewById(R.id.bt_write);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File file = new File("/sdcard",fileNameTxt.getText().toString());
                    FileOutputStream fp = new FileOutputStream(file);
                    fp.write(contentText.getText().toString().getBytes());
                    fp.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String ip,text = "";
                    File file = new File("/sdcard",fileNameTxt.getText().toString());
                    BufferedReader bf = new BufferedReader(new FileReader(file));
                    while ((ip = bf.readLine())!= null)text+=ip;
                    contentText.setText(text);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}