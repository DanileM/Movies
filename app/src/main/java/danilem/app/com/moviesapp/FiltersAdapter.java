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
import java.util.Collections;
import java.util.List;

import danilem.app.com.moviesapp.Module.Example;

public class FiltersAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<Title> titles;
    boolean[] checked;

    FiltersAdapter(Context context, List<Title> titles){
        this.context = context;
        this.titles = titles;
    }

    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader(position))
            return Title.TITLE_TYPE;
        return Title.CHECKBOXES_TYPE;
    }

    private boolean isPositionHeader(int position){
        return titles.get(position) instanceof Title;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if(i == Title.TITLE_TYPE){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_title_list_item, viewGroup, false);
            return  new FilterTitleViewHolder(v);
        }else if (i == Title.CHECKBOXES_TYPE){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_list_item, viewGroup, false);
            return new FilterCheckBoxViewHolder(v);
        }

        throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        switch (viewHolder.getItemViewType()){
            case Title.TITLE_TYPE:
                ((FilterTitleViewHolder) viewHolder).title.setText(titles.get(i).getTitle());
                break;
            case Title.CHECKBOXES_TYPE:
                for(int j = 0; j < TitlesData.dataCheckboxes.get(i).size(); j++)
                    ((FilterCheckBoxViewHolder) viewHolder).cbFilter.setText(TitlesData.dataCheckboxes.get(i).get(j));
                }
    }

    @Override
    public int getItemCount() {
        return titles.size();
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
}