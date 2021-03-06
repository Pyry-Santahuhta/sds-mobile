package com.example.sds_mobile_project;

import java.io.Serializable;

public class Recipe implements Serializable {
    private String title = "";
    private String ingredients = "";
    private String instructions = "";
    private String image = null;

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String  image) {
        this.image = image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getTitle() {
        return title;
    }

    public String  getImage() {
        return image;
    }


}
