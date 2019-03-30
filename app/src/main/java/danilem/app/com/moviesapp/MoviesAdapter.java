package danilem.app.com.moviesapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import danilem.app.com.moviesapp.Module.Example;
import danilem.app.com.moviesapp.Module.Value;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private Context context;
    private Example values;

    MoviesAdapter(Context context, Example values){
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.movie_list_item, viewGroup, false);

        return new MovieViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {

        Picasso.get().load(values.getValues().get(i).getImage()).into(movieViewHolder.image);
        movieViewHolder.title.setText(values.getValues().get(i).getTitle());
        movieViewHolder.year.setText(values.getValues().get(i).getYear());
        movieViewHolder.genre.setText(Arrays.toString(values.getValues().get(i).getGenre().toArray()));
        movieViewHolder.director.setText(values.getValues().get(i).getDirector());
        movieViewHolder.description.setText(values.getValues().get(i).getDesription());
        
    }

    @Override
    public int getItemCount() {
        return values.getValues().size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        TextView year;
        TextView genre;
        TextView director;
        TextView description;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.iv_image);
            title = itemView.findViewById(R.id.tv_title);
            year = itemView.findViewById(R.id.tv_year);
            genre = itemView.findViewById(R.id.tv_genre);
            director = itemView.findViewById(R.id.tv_director);
            description = itemView.findViewById(R.id.tv_description);
        }
    }

}
