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
                FiltersAdapter adapter = new FiltersAdapter(FiltersActivity.this, getModelList());
                recyclerView.setAdapter(adapter);

            }
        });
    }

    private ArrayList<Model> getModelList() {
        ArrayList<Model> list = new ArrayList<>();

        Model drama = new Model("Drama");
        Model crime = new Model("Crime");
        Model action = new Model("Action");
        Model adventure = new Model("Adventure");
        Model fantasy = new Model("Fantasy");
        Model biography = new Model("Biography");
        Model history = new Model("History");
        Model romance = new Model("Romance");
        Model scifi = new Model("Sci-Fi");
        Model war = new Model("War");
        Model comedy = new Model("Comedy");

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

//        Model years = new Model("Years");
//        list.add(years);
//
//        Model year1994 = new Model("1994");
//        Model year1972 = new Model("1972");
//        Model year2008 = new Model("2008");
//        Model year1974 = new Model("1974");
//        Model year2003 = new Model("2003");
//        Model year1993 = new Model("1993");
//        Model year1957 = new Model("1957");
//        Model year1999 = new Model("1999");
//        Model year2001 = new Model("2001");
//        Model year2002 = new Model("2002");
//        Model year1990 = new Model("1990");
//        Model year1975 = new Model("1975");
//        Model year2014 = new Model("2014");
//        Model year1998 = new Model("1998");
//        Model year1997 = new Model("1997");
//
//        list.add(year1957);
//        list.add(year1972);
//        list.add(year1974);
//        list.add(year1975);
//        list.add(year1990);
//        list.add(year1993);
//        list.add(year1994);
//        list.add(year1997);
//        list.add(year1998);
//        list.add(year1999);
//        list.add(year2001);
//        list.add(year2002);
//        list.add(year2003);
//        list.add(year2008);
//        list.add(year2014);

        return list;
    }
}

