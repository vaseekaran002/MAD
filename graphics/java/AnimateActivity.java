package com.example.graphicsprimitives;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);


        final ImageView canvasImage  = (ImageView) findViewById(R.id.carImage);

        Bitmap bitmap = Bitmap.createBitmap(1080,1920,Bitmap.Config.ARGB_8888);
        canvasImage.setImageBitmap(bitmap);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        paint.setColor(Color.GREEN);
        canvas.drawRect(50,100,450,300,paint);
        paint.setColor(Color.YELLOW);
        RectF roof = new RectF(100,0,400,200);
        canvas.drawArc(roof,180,180,false,paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(150,300,50,paint);
        canvas.drawCircle(350,300,50,paint);

        canvasImage.animate().translationX(400).setDuration(2000);
    }
}
