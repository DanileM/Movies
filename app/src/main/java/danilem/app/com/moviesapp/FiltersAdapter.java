package danilem.app.com.moviesapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import danilem.app.com.moviesapp.Module.Example;
import danilem.app.com.moviesapp.Module.Value;

public class FiltersAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<String> genres;
    private ArrayList<ArrayList<String>> genreListValues;
    private Example values;
    boolean[] checked;

    private final int TYPE_ITEM1 = 0;
    private final int TYPE_ITEM2 = 1;

    FiltersAdapter(Context context, Example values, List<String> genres){
        this.context = context;
        this.genres = genres;
        this.values = values;
        checked = new boolean[values.getValues().size()];
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_ITEM1;

        return TYPE_ITEM2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if(i == TYPE_ITEM1){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_title_list_item, viewGroup, false);
            return  new FilterTitleViewHolder(v);
        }else if (i == TYPE_ITEM2){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_list_item, viewGroup, false);
            return new FilterCheckBoxViewHolder(v);
        }

        throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        switch (viewHolder.getItemViewType()){
            case TYPE_ITEM1:
                ((FilterTitleViewHolder) viewHolder).title.setText(genres.get(i));
                break;
            case TYPE_ITEM2:
                for(int j = 0; j<getGenreListValues().size(); j++){
                    ((FilterCheckBoxViewHolder) viewHolder).cbFilter.setText(getGenreListValues().get(j).get(i));
                }
        }
    }

    @Override
    public int getItemCount() {
        return values.getValues().size();
    }


    public static class FilterCheckBoxViewHolder extends RecyclerView.ViewHolder{

        CheckBox cbFilter;

        public FilterCheckBoxViewHolder(@NonNull View itemView) {
            super(itemView);
            cbFilter = itemView.findViewById(R.id.cb_filter);
        }
    }

    public static class FilterTitleViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public FilterTitleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title_item);
        }
    }

    private ArrayList<ArrayList<String>> getGenreListValues(){
        genreListValues = new ArrayList<>();

        ArrayList<String> genreValues = new ArrayList<>();
        ArrayList<String> yearsValues = new ArrayList<>();
        ArrayList<String> directorsValues = new ArrayList<>();

        for(int j = 0; j<values.getValues().size(); j++){
            for(int k = 0; k<values.getValues().get(j).getGenre().size(); k++){
                genreValues.add(values.getValues().get(j).getGenre().get(k));
            }
        }

        for (int j = 0; j<values.getValues().size(); j++){
            yearsValues.add(values.getValues().get(j).getYear());
        }

        for (int j = 0; j<values.getValues().size(); j++){
            directorsValues.add(values.getValues().get(j).getDirector());
        }

        genreListValues.add(genreValues);
        genreListValues.add(yearsValues);
        genreListValues.add(directorsValues);

        return genreListValues;
    }
}