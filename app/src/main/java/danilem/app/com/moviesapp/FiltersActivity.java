package danilem.app.com.moviesapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
                FiltersAdapter adapter = new FiltersAdapter(FiltersActivity.this, getList());
                recyclerView.setAdapter(adapter);

            }
        });
    }

    private ArrayList<ListItem> getList(){
        ArrayList<ListItem> list = new ArrayList<>();

        Header header = new Header();
        header.setHeader("Genres");
        list.add(header);

        Rows drama = new Rows("Drama");
        Rows crime = new Rows("Crime");
        Rows action = new Rows("Action");
        Rows adventure = new Rows("Adventure");
        Rows fantasy = new Rows("Fantasy");
        Rows biography = new Rows("Biography");
        Rows history = new Rows("History");
        Rows romance = new Rows("Romance");
        Rows scifi = new Rows("Sci-Fi");
        Rows war = new Rows("War");
        Rows comedy = new Rows("Comedy");

        list.add(action);
        list.add(adventure);
        list.add(biography);
        list.add(comedy);
        list.add(crime);
        list.add(drama);
        list.add(fantasy);
        list.add(history);
        list.add(romance);
        list.add(scifi);
        list.add(war);

        return list;
    }
}
