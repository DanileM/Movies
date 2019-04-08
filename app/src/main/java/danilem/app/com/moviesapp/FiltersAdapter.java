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

public class FiltersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int HEADER_TYPE = 0;
    private static final int ROW_TYPE = 1;

    private Context context;
    private List<Model> listItems;

    FiltersAdapter(Context context, List<Model> listItems){
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return HEADER_TYPE;
        return ROW_TYPE;
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if(i == HEADER_TYPE){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_title_list_item, viewGroup, false);
            return  new FilterTitleViewHolder(v);
        }else if (i == ROW_TYPE){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_list_item, viewGroup, false);
            return new FilterCheckBoxViewHolder(v);
        }

        throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        switch (viewHolder.getItemViewType()) {
            case HEADER_TYPE:
                ((FilterTitleViewHolder) viewHolder).title.setText(listItems.get(i).getName());
                break;
            case ROW_TYPE:
                ((FilterCheckBoxViewHolder) viewHolder).cbFilter.setText(listItems.get(i).getName());
        }
    }

    private class FilterTitleViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public FilterTitleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title_item);
        }
    }

    private class FilterCheckBoxViewHolder extends RecyclerView.ViewHolder{

        CheckBox cbFilter;

        public FilterCheckBoxViewHolder(@NonNull View itemView) {
            super(itemView);
            cbFilter = itemView.findViewById(R.id.cb_filter);
        }
    }
}