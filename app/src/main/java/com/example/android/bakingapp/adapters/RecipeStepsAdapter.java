package com.example.android.bakingapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.R;

/**
 * Created by tp293 on 1/4/2018.
 */

public class RecipeStepsAdapter extends RecyclerView.Adapter<RecipeStepsAdapter.RecipeStepsViewHolder> {

    private Context mContext;
    private String[] mRecipeStepsArray;

    @Override
    public RecipeStepsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        int viewHolderLayout = R.layout.recipe_item;

        View view = layoutInflater.inflate(viewHolderLayout, parent, false);
        return new RecipeStepsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeStepsViewHolder holder, int position) {
        /*
        Recipe holderRecipe = mRecipeArray[position];
        holder.mRecipeTextView.setText(holderRecipe.getName());
        */
    }

    @Override
    public int getItemCount() {
        if (mRecipeStepsArray == null) {
            return 0;
        } else {
            return mRecipeStepsArray.length;
        }
    }

    /*** MUST UPDATE ***/
    public void setRecipeArrayData(String[] recipeArrayData) {
        mRecipeStepsArray = recipeArrayData;
        notifyDataSetChanged();
    }

    public class RecipeStepsViewHolder extends RecyclerView.ViewHolder {

        TextView mRecipeStepTextView;

        public RecipeStepsViewHolder(View itemView) {
            super(itemView);
            mRecipeStepTextView = (TextView) itemView.findViewById(R.id.tv_recipe_step_description);
        }
    }
}
