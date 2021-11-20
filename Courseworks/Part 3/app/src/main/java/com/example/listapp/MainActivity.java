package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView pastaRecyclerView;
    RecyclerViewAdapter pastaAdapter;
    String[] pastas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();
        pastaRecyclerView = findViewById(R.id.pastaRecyclerView);
        pastas = res.getStringArray(R.array.pastas);
        pastaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        pastaAdapter = new RecyclerViewAdapter(this, pastas);
        pastaRecyclerView.setAdapter(pastaAdapter);
    }
}