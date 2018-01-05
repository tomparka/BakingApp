package com.example.android.bakingapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tp293 on 12/27/2017.
 */

public class Recipe implements Parcelable{
    private int id;
    private String name;
    private Ingredient[] ingredients;
    private RecipeStep[] recipeSteps;
    private int servings;
    private String imageUrl;

    public Recipe() {
    }

    protected Recipe(Parcel in) {
        id = in.readInt();
        name = in.readString();
        ingredients = in.createTypedArray(Ingredient.CREATOR);
        recipeSteps = in.createTypedArray(RecipeStep.CREATOR);
        servings = in.readInt();
        imageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeTypedArray(ingredients, flags);
        dest.writeTypedArray(recipeSteps, flags);
        dest.writeInt(servings);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeStep[] getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(RecipeStep[] recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static class Ingredient implements Parcelable{
        private int quantity;
        private String measure;
        private String name;

        public Ingredient() {}

        protected Ingredient(Parcel in) {
            quantity = in.readInt();
            measure = in.readString();
            name = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(quantity);
            dest.writeString(measure);
            dest.writeString(name);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
            @Override
            public Ingredient createFromParcel(Parcel in) {
                return new Ingredient(in);
            }

            @Override
            public Ingredient[] newArray(int size) {
                return new Ingredient[size];
            }
        };

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getMeasure() {
            return measure;
        }

        public void setMeasure(String measure) {
            this.measure = measure;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class RecipeStep implements Parcelable{
        private int id;
        private String shortDescription;
        private String fullDescription;
        private String videoUrl;
        private String thumbnailUrl;

        public RecipeStep() {}

        protected RecipeStep(Parcel in) {
            id = in.readInt();
            shortDescription = in.readString();
            fullDescription = in.readString();
            videoUrl = in.readString();
            thumbnailUrl = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(shortDescription);
            dest.writeString(fullDescription);
            dest.writeString(videoUrl);
            dest.writeString(thumbnailUrl);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<RecipeStep> CREATOR = new Creator<RecipeStep>() {
            @Override
            public RecipeStep createFromParcel(Parcel in) {
                return new RecipeStep(in);
            }

            @Override
            public RecipeStep[] newArray(int size) {
                return new RecipeStep[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public String getFullDescription() {
            return fullDescription;
        }

        public void setFullDescription(String fullDescription) {
            this.fullDescription = fullDescription;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }
    }
}
