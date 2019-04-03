package danilem.app.com.moviesapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import danilem.app.com.moviesapp.Module.Example;

public class FiltersActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        recyclerView = findViewById(R.id.rc_filters);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        final MoviesViewModel model = ViewModelProviders.of(this).get(MoviesViewModel.class);

        model.getMovies().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(@Nullable Example example) {
                FiltersAdapter adapter = new FiltersAdapter(FiltersActivity.this, TitlesData.getGenres());
                recyclerView.setAdapter(adapter);

            }
        });
    }
}
