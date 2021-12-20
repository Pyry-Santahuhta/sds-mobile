package com.example.sds_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class recipeDetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);

        Intent intent = getIntent();

        if(intent.hasExtra("title")){
            TextView titleTextView = findViewById(R.id.titleTextView);
            TextView numberTextView = findViewById(R.id.numberTextView);
            TextView ingredientsTextView = findViewById(R.id.ingredientsTextView);
            TextView instructionsTextView = findViewById(R.id.instructionsTextView);
            ImageView imageView = findViewById(R.id.imageView);

            titleTextView.setText(intent.getStringExtra("title"));
            numberTextView.setText("Recipe #" + intent.getStringExtra("index"));
            ingredientsTextView.setText(intent.getStringExtra("ingredients"));
            instructionsTextView.setText(intent.getStringExtra("instructions"));

            if(intent.hasExtra("image")){
                imageView.setImageURI(Uri.parse(intent.getStringExtra("image")));
            }
        }
    }
}