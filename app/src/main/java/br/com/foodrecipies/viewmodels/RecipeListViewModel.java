package br.com.foodrecipies.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.foodrecipies.models.Recipe;
import br.com.foodrecipies.repository.RecipeRepository;


public class RecipeListViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;

    public RecipeListViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipeRepository.getRecipes();
    }
    public void searchRecipesApi(String query, int pageNumber){
        mRecipeRepository.searchRecipesApi(query, pageNumber);
    }

}