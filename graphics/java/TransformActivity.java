package com.example.graphicsprimitives;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TransformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform);

        final ImageView img1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView img2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView img3 = (ImageView) findViewById(R.id.imageView3);


        Animation fade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        img1.startAnimation(fade);

        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        img2.startAnimation(rotate);

        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        img3.startAnimation(zoom);
    }
}
