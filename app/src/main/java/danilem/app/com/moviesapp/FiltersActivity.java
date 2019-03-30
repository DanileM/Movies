package danilem.app.com.moviesapp;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import danilem.app.com.moviesapp.Module.Example;
import danilem.app.com.moviesapp.Module.Value;
import danilem.app.com.moviesapp.REST.JSONPlaceHolderApi;
import danilem.app.com.moviesapp.REST.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FiltersActivity extends Activity {

    private static final String TAG = "MoviesFilter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
