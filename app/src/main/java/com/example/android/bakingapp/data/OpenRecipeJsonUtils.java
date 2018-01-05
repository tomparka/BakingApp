package com.example.android.bakingapp.data;

import android.content.Context;
import android.os.Parcel;

import com.example.android.bakingapp.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tp293 on 12/26/2017.
 */

public final class OpenRecipeJsonUtils {

    /*
     * @param forecastJsonStr JSON response from server
     *
     * @return Array of Strings describing weather data
     *
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static Recipe[] getRecipeObjArrayFromJson(Context context, String recipeJsonStr)
            throws JSONException {
        /* holds array of parsed recipe objects */
        Recipe[] parsedRecipeData = null;

        JSONArray recipeJsonArray = new JSONArray(recipeJsonStr);
        parsedRecipeData = new Recipe[recipeJsonArray.length()];

        for (int i = 0; i < recipeJsonArray.length(); i++) { //for each recipe in the array

            //set recipe
            Recipe currentRecipe = new Recipe();
            JSONObject currentRecipeJsonObj= recipeJsonArray.getJSONObject(i);
            currentRecipe.setId(currentRecipeJsonObj.getInt("id"));
            currentRecipe.setName(currentRecipeJsonObj.getString("name"));
            currentRecipe.setServings(currentRecipeJsonObj.getInt("servings"));
            currentRecipe.setImageUrl(currentRecipeJsonObj.getString("image"));

            //set ingredients
            JSONArray ingredientsJsonArray = currentRecipeJsonObj.getJSONArray("ingredients");
            Recipe.Ingredient[] currentRecipeIngredients = new Recipe.Ingredient[ingredientsJsonArray.length()];
            for (int j = 0; j < ingredientsJsonArray.length(); j++){

                Recipe.Ingredient currentIngredient = new Recipe.Ingredient();
                JSONObject currentIngredientJsonObj = ingredientsJsonArray.getJSONObject(j);
                currentIngredient.setQuantity(currentIngredientJsonObj.getInt("quantity"));
                currentIngredient.setMeasure(currentIngredientJsonObj.getString("measure"));
                currentIngredient.setName(currentIngredientJsonObj.getString("ingredient"));

                currentRecipeIngredients[j] = currentIngredient;
            }
            currentRecipe.setIngredients(currentRecipeIngredients);

            //set steps
            JSONArray stepsJsonArray = currentRecipeJsonObj.getJSONArray("steps");
            Recipe.RecipeStep[] currentRecipeSteps = new Recipe.RecipeStep[stepsJsonArray.length()];
            for (int k = 0; k < stepsJsonArray.length(); k++) {

                Recipe.RecipeStep currentStep = new Recipe.RecipeStep();
                JSONObject currentStepJsonObj = stepsJsonArray.getJSONObject(k);
                currentStep.setId(currentStepJsonObj.getInt("id"));
                currentStep.setShortDescription(currentStepJsonObj.getString("shortDescription"));
                currentStep.setFullDescription(currentStepJsonObj.getString("description"));
                currentStep.setVideoUrl(currentStepJsonObj.getString("videoURL"));
                currentStep.setThumbnailUrl(currentStepJsonObj.getString("thumbnailURL"));

                currentRecipeSteps[k] = currentStep;
            }
            currentRecipe.setRecipeSteps(currentRecipeSteps);

            parsedRecipeData[i] = currentRecipe;
        }

        return parsedRecipeData;
    }

}
