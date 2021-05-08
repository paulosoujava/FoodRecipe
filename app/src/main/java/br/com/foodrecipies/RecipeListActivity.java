package br.com.foodrecipies;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;
import java.util.List;

import br.com.foodrecipies.models.Recipe;
import br.com.foodrecipies.requests.RecipeApi;
import br.com.foodrecipies.requests.ServiceGenerator;
import br.com.foodrecipies.requests.responses.RecipeResponse;
import br.com.foodrecipies.util.Constants;
import br.com.foodrecipies.util.Testing;
import br.com.foodrecipies.viewmodels.RecipeListViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "LOG";
    private RecipeListViewModel mRecipeListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        mRecipeListViewModel = viewModelProvider.get(RecipeListViewModel.class);
        subscribeObservers();

        findViewById(R.id.test).setOnClickListener(v -> testRetrofitRequest());
    }

    private void subscribeObservers(){
        mRecipeListViewModel.getRecipes().observe(this, recipes -> {
            if(recipes != null){
                Testing.printRecipes("network test", recipes);
            }
        });
    }

    private void testRetrofitRequest(){
        mRecipeListViewModel.searchRecipesApi("Meatball", 1);
    }

}