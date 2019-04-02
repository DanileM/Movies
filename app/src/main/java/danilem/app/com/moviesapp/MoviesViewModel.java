package danilem.app.com.moviesapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import danilem.app.com.moviesapp.Module.Example;
import danilem.app.com.moviesapp.REST.JSONPlaceHolderApi;
import danilem.app.com.moviesapp.REST.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewModel extends ViewModel {

    private static final String TAG = "MoviesViewModel";

    private MutableLiveData<Example> moviesList;

    public LiveData<Example> getMovies() {
        if (moviesList == null) {
            moviesList = new MutableLiveData<>();
            loadMovies();
        }
        return moviesList;
    }

    public void setMoviesList(MutableLiveData<Example> example){
        this.moviesList = example;
    }

    private void loadMovies() {
        JSONPlaceHolderApi service = NetworkService.getJSONApi();
        Call<Example> call = service.getValues();
        call.enqueue(new Callback<Example>(){
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    moviesList.setValue(response.body());

                    Log.i(TAG, "Response call");
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.i(TAG, "Failure call");
            }
        });
    }
}
