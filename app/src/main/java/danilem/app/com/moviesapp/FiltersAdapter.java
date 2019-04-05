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

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ROW = 1;

    private Context context;
    private List<ListItem> listItems;

    FiltersAdapter(Context context, List<ListItem> listItems){
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ROW;
    }

    private boolean isPositionHeader(int position){
        return listItems.get(position) instanceof Header;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if(i == TYPE_HEADER){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_title_list_item, viewGroup, false);
            return  new FilterTitleViewHolder(v);
        }else if (i == TYPE_ROW){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_list_item, viewGroup, false);
            return new FilterCheckBoxViewHolder(v);
        }

        throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        switch (viewHolder.getItemViewType()) {
            case TYPE_HEADER:
                Header header = (Header) listItems.get(i);
                FilterTitleViewHolder filterTitleVH = (FilterTitleViewHolder) viewHolder;
                filterTitleVH.title.setText(header.getHeader());
                break;
            case TYPE_ROW:
                Rows row = (Rows) listItems.get(i);
                ((FilterCheckBoxViewHolder) viewHolder).cbFilter.setText(((Rows) listItems.get(i)).getRow());
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
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