package com.example.android.bakingapp.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.fragments.MediaPlayerFragment;
import com.example.android.bakingapp.fragments.StepInstructionsFragment;

public class RecipeStepDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_step_detail);
        Log.d("RecipeStepDetailActivit", Integer.toString(getIntent().getExtras().getInt("SELECTED_STEP")));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MediaPlayerFragment mediaPlayerFragment = new MediaPlayerFragment();
        StepInstructionsFragment stepInstructionsFragment = new StepInstructionsFragment();

        fragmentTransaction.add(R.id.exoplayer_container, mediaPlayerFragment)
                .add(R.id.recipe_step_instructions_container, stepInstructionsFragment);
        fragmentTransaction.commit();
    }
}
