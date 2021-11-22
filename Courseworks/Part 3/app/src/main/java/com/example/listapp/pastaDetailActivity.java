package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class pastaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasta_detail);

        if(getIntent().hasExtra("title")){
            TextView titleTextView = findViewById(R.id.titleTextView);
            TextView numberTextView = findViewById(R.id.numberTextView);
            TextView descriptionTextView = findViewById(R.id.descriptionTextView);

            titleTextView.setText(getIntent().getExtras().getString("title"));
            numberTextView.setText(getIntent().getExtras().getString("pastaNumber"));
            descriptionTextView.setText(getIntent().getExtras().getString("pastaDescription"));

            ImageView imageView = findViewById(R.id.imageView);
            int index = getIntent().getIntExtra("index", -1);
            imageView.setImageURI(Uri.parse("./"));

            if(index > -1){
                int pic = getImg(index);
                scaleImg(imageView, pic);
            }
        }
    }
    private int getImg(int index){
        switch (index){
            case 0: return R.drawable.spaghetti;
            case 1: return  R.drawable.penne;
            case 2: return  R.drawable.linguine;
            case 3: return  R.drawable.fusilli;
            default:return -1;
        }
    }

    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth){
            int ratio = Math.round((float) imgWidth/ (float) screenWidth);
            options.inSampleSize = ratio;
        }
        options.inJustDecodeBounds = false;

        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);

        img.setImageBitmap(Bitmap.createScaledBitmap(scaledImg, 700, 700, false));
    }
}