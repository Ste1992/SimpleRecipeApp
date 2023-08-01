package com.example.recipeappchallenge;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imageView;
    private int imageID;
    private TextView title, text, ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.image_recipe);
        title = findViewById(R.id.textView_detailTitle);
        text = findViewById(R.id.textView_detailText);
        ingredients = findViewById(R.id.textView_detailIngredients);

        Intent intent = getIntent();
        imageID = intent.getIntExtra("image", 0);
        String iTitle = intent.getStringExtra("title");
        String iText = intent.getStringExtra("text");
        String iIngredients = intent.getStringExtra("ingredients");

        if(imageID != 0) {
            imageView.setImageResource(imageID);
        } else {
            //Do nothing
        }

        if(title != null) {
            title.setText(iTitle);
        } else {
            // Do nothing
        }

        if(text != null) {
            text.setText(iText);
        } else {
            // Do nothing
        }

        if(ingredients != null) {
            ingredients.setText(iIngredients);
        } else {
            //Do nothing
        }

    }
}