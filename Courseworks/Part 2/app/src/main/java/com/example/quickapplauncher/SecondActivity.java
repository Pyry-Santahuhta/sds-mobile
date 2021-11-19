package com.example.quickapplauncher;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getIntent().hasExtra("text")){
            TextView tv = findViewById(R.id.textView);
            tv.setText(getIntent().getExtras().getString("text"));

        }
    }
}