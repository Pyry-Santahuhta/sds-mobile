package com.example.sds_mobile_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {
    ArrayList<Recipe> recipes;
    RecyclerView recipeRecyclerView;
    RecyclerViewAdapter recipeAdapter;
    Button addRecipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent().hasExtra("recipes")){
            System.out.println("got recipes"+(ArrayList<Recipe>) getIntent().getSerializableExtra("recipes"));
            recipes = (ArrayList<Recipe>) getIntent().getSerializableExtra("recipes");

        }else{
            recipes = new ArrayList<Recipe>();
        }
        Resources res = getResources();
        recipeRecyclerView = findViewById(R.id.recipeRecyclerView);

        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeAdapter = new RecyclerViewAdapter(this, recipes, this);
        recipeRecyclerView.setAdapter(recipeAdapter);

        addRecipeButton = findViewById(R.id.addRecipeButton);

        addRecipeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, newRecipeActivity.class);
            intent.putExtra("recipes", recipes);
            startActivity(intent);
        });
    }

    @Override
    public void onItemClick(int position) {
        System.out.println(recipes.get(position));

        Intent intent = new Intent(this, recipeDetailActivity.class);
        intent.putExtra("title", recipes.get(position).getTitle());
        intent.putExtra("ingredients", recipes.get(position).getIngredients());
        intent.putExtra("instructions", recipes.get(position).getInstructions());

        intent.putExtra("index", String.valueOf(position+1));

        startActivity(intent);


    }
}