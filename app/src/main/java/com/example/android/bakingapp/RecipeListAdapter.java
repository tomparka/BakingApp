package com.example.android.bakingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tp293 on 12/26/2017.
 */

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder> {

    private Context mContext;

    @Override
    public RecipeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        int viewHolderLayout = R.layout.recipe_item;

        View view = layoutInflater.inflate(viewHolderLayout, parent, false);
        return new RecipeListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class RecipeListViewHolder extends RecyclerView.ViewHolder {

        public RecipeListViewHolder(View itemView) {
            super(itemView);
        }


    }

}
