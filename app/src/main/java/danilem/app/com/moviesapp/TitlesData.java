package danilem.app.com.moviesapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import danilem.app.com.moviesapp.Module.Example;

public class TitlesData{

    public static ArrayList<ArrayList<String>> dataCheckboxes;

    public static List<Title> getGenres(){
        List<Title> listTitles = new ArrayList<>();
        listTitles.add(new Title("Genre" , Title.TITLE_TYPE));
        listTitles.add(new Title("Years" , Title.TITLE_TYPE));
        listTitles.add(new Title("Directors" , Title.TITLE_TYPE));
        return listTitles;
    }

    public static ArrayList<ArrayList<String>> setGenreListValues(Example values){
        dataCheckboxes = new ArrayList<>();

        ArrayList<String> genreValues = new ArrayList<>();
        ArrayList<String> yearsValues = new ArrayList<>();
        ArrayList<String> directorsValues = new ArrayList<>();

        for(int j = 0; j<values.getValues().size(); j++){
            for(int k = 0; k<values.getValues().get(j).getGenre().size(); k++){
                if(!genreValues.contains(values.getValues().get(j).getGenre().get(k)))
                    genreValues.add(values.getValues().get(j).getGenre().get(k));
            }
        }

        for (int j = 0; j<values.getValues().size(); j++){
            if(!yearsValues.contains(values.getValues().get(j).getYear()))
                yearsValues.add(values.getValues().get(j).getYear());
        }

        for (int j = 0; j<values.getValues().size(); j++){
            String director = values.getValues().get(j).getDirector().trim();
            if(!directorsValues.contains(director))
                directorsValues.add(values.getValues().get(j).getDirector());
        }

        Collections.sort(genreValues);
        Collections.sort(yearsValues);
        Collections.sort(directorsValues);

        dataCheckboxes.add(genreValues);
        dataCheckboxes.add(yearsValues);
        dataCheckboxes.add(directorsValues);

        return dataCheckboxes;
    }
}
