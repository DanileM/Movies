package danilem.app.com.moviesapp.REST;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static final String BASE_URL = "https://demo0216585.mockable.io/";

    private static Retrofit NetworkService(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static JSONPlaceHolderApi getJSONApi() {
        return NetworkService().create(JSONPlaceHolderApi.class);
    }
}

