package danilem.app.com.moviesapp;

import android.app.ActionBar;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import danilem.app.com.moviesapp.Module.Example;
import danilem.app.com.moviesapp.Module.Value;
import danilem.app.com.moviesapp.REST.JSONPlaceHolderApi;
import danilem.app.com.moviesapp.REST.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FiltersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<String> genreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        recyclerView = findViewById(R.id.rc_filters);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        final MoviesViewModel model = ViewModelProviders.of(this).get(MoviesViewModel.class);

        genreList = new ArrayList<>();
        genreList.add("Genre");
        genreList.add("Years");
        genreList.add("Directors");


        model.getMovies().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(@Nullable Example example) {
                FiltersAdapter adapter = new FiltersAdapter(FiltersActivity.this, example, genreList);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}
