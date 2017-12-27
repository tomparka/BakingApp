package com.example.android.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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

        myAdapter = new RecipeListAdapter();
        mRecyclerView.setAdapter(myAdapter);
    }
}
