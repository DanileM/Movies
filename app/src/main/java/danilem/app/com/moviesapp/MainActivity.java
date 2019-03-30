package danilem.app.com.moviesapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import danilem.app.com.moviesapp.Module.Example;
import danilem.app.com.moviesapp.Module.Value;
import danilem.app.com.moviesapp.REST.JSONPlaceHolderApi;
import danilem.app.com.moviesapp.REST.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private static final String TAG = "MoviesApp";

    RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filters:
                Intent intent = new Intent(this, FiltersActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rc_movies);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        JSONPlaceHolderApi service = NetworkService.getJSONApi();
        Call <Example> call = service.getValues();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example data = response.body();

                if(response.isSuccessful()) {
                    if(data != null) {
                        MoviesAdapter moviesAdapter = new MoviesAdapter(MainActivity.this, data);
                        recyclerView.setAdapter(moviesAdapter);

                        Log.i(TAG, "Response call");
                    }else{
                        Log.i(TAG, "Data is null");
                    }
                }else{
                    Log.i(TAG, "Response does not successful");
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.i(TAG, "Failure call");
            }
        });
    }
}
