package com.example.android.bakingapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.Recipe;

/**
 * Created by tp293 on 12/26/2017.
 */

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder> {

    private Context mContext;
    private final RecipeListAdapterOnClickHandler mClickHandler;
    private Recipe[] mRecipeArray;

    public interface RecipeListAdapterOnClickHandler {
        void onClick (Recipe recipe);
    }

    public RecipeListAdapter (RecipeListAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

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

        Recipe holderRecipe = mRecipeArray[position];
        holder.mRecipeTextView.setText(holderRecipe.getName());
    }

    @Override
    public int getItemCount() {
        if (mRecipeArray == null) {
            return 0;
        } else {
            return mRecipeArray.length;
        }
    }

    public void setRecipeArrayData(Recipe[] recipeArrayData) {
        mRecipeArray = recipeArrayData;
        notifyDataSetChanged();
    }


    /*
    Inner class ViewHolder
     */
    public class RecipeListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mRecipeTextView;

        public RecipeListViewHolder(View itemView) {
            super(itemView);
            mRecipeTextView = itemView.findViewById(R.id.tv_recipe);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Log.d("RecipeListAdapter", "Adapter position" + Integer.toString(adapterPosition) + "clicked");
            Recipe recipe = mRecipeArray[adapterPosition];
            mClickHandler.onClick(recipe);

        }
    }

}
