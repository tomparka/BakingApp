package com.example.android.bakingapp.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.Recipe;
import com.example.android.bakingapp.adapters.RecipeListAdapter;
import com.example.android.bakingapp.data.NetworkUtils;
import com.example.android.bakingapp.data.OpenRecipeJsonUtils;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecipeListAdapter.RecipeListAdapterOnClickHandler {

    private RecipeListAdapter myAdapter;
    private GridLayoutManager recipeLayoutManager;

    @BindView(R.id.rv_recipe_list) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        recipeLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(recipeLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        myAdapter = new RecipeListAdapter(this);
        mRecyclerView.setAdapter(myAdapter);

        new RecipeDataTask().execute();
    }

    @Override
    public void onClick(Recipe recipe) {
        Log.d(this.getClass().getName(), "onClick called");
        Context context = this;
        Class destinationClass = RecipeStepsActivity.class;
        Intent intent = new Intent(context, destinationClass);
        intent.putExtra(Intent.EXTRA_TEXT, recipe);
        startActivity(intent);
    }

    public class RecipeDataTask extends AsyncTask<Void, Void, Recipe[]> {

        @Override
        protected Recipe[] doInBackground(Void... voids) {

            URL recipeRequestUrl = null;

            try {
                recipeRequestUrl = new URL(NetworkUtils.RECIPE_JSON_URL);
                String jsonRecipeResponse = NetworkUtils
                        .getResponseFromHttpUrl(recipeRequestUrl);

                Recipe[] recipeDataArray = OpenRecipeJsonUtils
                        .getRecipeObjArrayFromJson(MainActivity.this, jsonRecipeResponse);

                return recipeDataArray;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Recipe[] recipeData) {
            super.onPostExecute(recipeData);
            if (recipeData != null) {
                myAdapter.setRecipeArrayData(recipeData);
            } else {
                Log.d("onPostExecute", "recipeData array is null");
            }
        }
    }
}
