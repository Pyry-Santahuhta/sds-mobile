package com.example.quickapplauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button changeActivityBtn = findViewById(R.id.activityChangeButton);
        changeActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeActivityIntent = new Intent(getApplicationContext(), SecondActivity.class);
                changeActivityIntent.putExtra("text", "Extra text sent through an intent :D");
                startActivity(changeActivityIntent);
            }
        });

        //Attempt to go to a website
        final Button googleBtn = findViewById(R.id.googleButton);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webAddress = Uri.parse("https://cat-bounce.com/");

                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webAddress);
                if(goToGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(goToGoogle);
                }
            }
        });

    }
}