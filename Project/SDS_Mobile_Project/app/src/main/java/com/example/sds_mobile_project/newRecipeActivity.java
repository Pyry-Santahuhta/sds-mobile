package com.example.sds_mobile_project;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class newRecipeActivity extends AppCompatActivity {

    Button submitButton;
    Button addImageButton;
    EditText titleEditText;
    EditText ingredientsEditText;
    EditText instructionsEditText;
    ArrayList<Recipe> recipes;
    Uri selectedImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_recipe);

        Resources res = getResources();
        if(getIntent().hasExtra("recipes")){
            recipes = (ArrayList<Recipe>) getIntent().getSerializableExtra("recipes");
        }

        submitButton = findViewById(R.id.submitButton);
        titleEditText = findViewById(R.id.titleEditText);
        ingredientsEditText = findViewById(R.id.ingredientsEditText);
        instructionsEditText = findViewById(R.id.instructionsEditText);
        addImageButton = findViewById(R.id.addImageButton);

        submitButton.setOnClickListener(v -> {
            insertRecipe(titleEditText.getText().toString(),
                    ingredientsEditText.getText().toString(),
                    instructionsEditText.getText().toString(),
                    recipes);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("recipes", recipes);
            System.out.println("sending recipes"+recipes.get(0).getTitle());
            startActivity(intent);
        });

        addImageButton.setOnClickListener(v -> {
            Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
        });



    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
            case 1:
                if(resultCode == RESULT_OK){
                    selectedImage = imageReturnedIntent.getData();
                }
                break;
        }
    }

    private void insertRecipe(String title, String ingredients, String instructions, ArrayList<Recipe> recipes){
    Gson gson = new Gson();
    try{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", title);
        jsonObject.put("ingredients", ingredients);
        jsonObject.put("instructions", instructions);
        if(selectedImage != null ){
            jsonObject.put("image", selectedImage);
        }
        Recipe recipe = gson.fromJson(String.valueOf(jsonObject), Recipe.class);
        recipes.add(recipe);
    }catch (JSONException e){
        e.printStackTrace();
    }

    }
}
