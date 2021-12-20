package com.example.sds_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class recipeDetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);

        if(getIntent().hasExtra("title")){
            TextView titleTextView = findViewById(R.id.titleTextView);
            TextView numberTextView = findViewById(R.id.numberTextView);
            TextView ingredientsTextView = findViewById(R.id.ingredientsTextView);
            TextView instructionsTextView = findViewById(R.id.instructionsTextView);

            titleTextView.setText(getIntent().getExtras().getString("title"));
            numberTextView.setText("Recipe #" + getIntent().getExtras().getString("index"));
            ingredientsTextView.setText(getIntent().getExtras().getString("ingredients"));
            instructionsTextView.setText(getIntent().getExtras().getString("instructions"));


        }
    }
}