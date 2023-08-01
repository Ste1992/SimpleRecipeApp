package com.example.recipeappchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<RecipeList> recipes;
    private Toolbar toolbar;
    private RecipeListAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recipes = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new RecipeListAdapter(this, recipes);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeData();
    }

    private void initializeData() {
        TypedArray recipesImageResource = getResources().obtainTypedArray(R.array.immaginiRicette);
        String[] recipeTitle = getResources().getStringArray(R.array.titoloRicette);
        String[] recipeDescription = getResources().getStringArray(R.array.descrizioneRicette);
        String[] recipeText = getResources().getStringArray(R.array.testoRicette);
        String[] recipeIngredients = getResources().getStringArray(R.array.IngredientiRicette);

        for (int i = 0; i < recipeTitle.length; i++) {
            recipes.add(new RecipeList(recipeTitle[i], recipeDescription[i], recipeText[i], recipeIngredients[i], recipesImageResource.getResourceId(i, 0)));
        }

        recipesImageResource.recycle();

        mAdapter.notifyDataSetChanged();
    }
}