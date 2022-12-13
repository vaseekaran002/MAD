package com.example.graphicsprimitives;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ShapesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

        final ImageView canvasImage  = (ImageView) findViewById(R.id.canvasImage);

        Bitmap bitmap = Bitmap.createBitmap(1000,1920,Bitmap.Config.ARGB_8888);
        canvasImage.setImageBitmap(bitmap);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        paint.setTextSize(50);
        paint.setColor(Color.MAGENTA);
        //To draw a Rectangle
        canvas.drawText("Rectangle", 420, 150, paint);
        canvas.drawRect(400, 200, 650, 700, paint);
        //To draw a Circle
        canvas.drawText("Circle", 120, 150, paint);
        canvas.drawCircle(200, 350, 150, paint);
        //To draw a Square
        canvas.drawText("Square", 120, 800, paint);
        canvas.drawRect(50, 850, 350, 1150, paint);
        //To draw a Line
        canvas.drawText("Line", 480, 800, paint);
        canvas.drawLine(520, 850, 520, 1150, paint);
    }
}
