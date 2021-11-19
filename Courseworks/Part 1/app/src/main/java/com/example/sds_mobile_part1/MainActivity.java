package com.example.sds_mobile_part1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText  num1 = findViewById(R.id.num1EditText);
                EditText num2 = findViewById(R.id.num2EditText);
                TextView resultTextView = findViewById(R.id.resultTextView);
                int result = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
                resultTextView.setText(result +"");


            }
        });

    }
}