package danilem.app.com.moviesapp.REST;

import android.renderscript.Sampler;

import java.util.List;

import danilem.app.com.moviesapp.Module.Example;
import danilem.app.com.moviesapp.Module.Value;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("movies")
    Call<Example> getValues();
}
