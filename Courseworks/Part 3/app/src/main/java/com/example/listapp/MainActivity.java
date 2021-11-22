package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    RecyclerView pastaRecyclerView;
    RecyclerViewAdapter pastaAdapter;
    String[] pastas;
    String[] pastaNumbers;
    String[] pastaDescriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();
        pastaRecyclerView = findViewById(R.id.pastaRecyclerView);
        pastas = res.getStringArray(R.array.pastas);
        pastaNumbers = res.getStringArray(R.array.pastaNumbers);
        pastaDescriptions = res.getStringArray(R.array.pastaDescriptions);

        pastaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        pastaAdapter = new RecyclerViewAdapter(this, pastas, this);
        pastaRecyclerView.setAdapter(pastaAdapter);



    }

    @Override
    public void onItemClick(int position) {
        System.out.println(pastas[position]);
        Intent intent = new Intent(this, pastaDetailActivity.class);
        intent.putExtra("title", pastas[position]);
        intent.putExtra("pastaNumber", pastaNumbers[position]);
        intent.putExtra("pastaDescription", pastaDescriptions[position]);
        intent.putExtra("index", position);

        startActivity(intent);
    }
}