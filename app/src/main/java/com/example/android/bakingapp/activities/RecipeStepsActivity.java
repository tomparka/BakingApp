package com.example.android.bakingapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.Recipe;
import com.example.android.bakingapp.fragments.RecipeStepsFragment;

public class RecipeStepsActivity extends AppCompatActivity implements RecipeStepsFragment.OnFragmentInteractionListener{

    public final String TAG = this.getClass().getName();
    Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);

        Recipe recipeFromIntent = getIntent().getExtras().getParcelable(Intent.EXTRA_TEXT);
        if (recipeFromIntent != null) {
            mRecipe = recipeFromIntent;
        } else {
            Log.d(TAG, "mRecipe is null");
        }
    }

    @Override
    public void onFragmentInteraction(int position) {

    }
}
