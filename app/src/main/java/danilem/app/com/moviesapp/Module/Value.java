package danilem.app.com.moviesapp.Module;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("genre")
    @Expose
    private List<String> genre;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("desription")
    @Expose
    private String desription;
    @SerializedName("image")
    @Expose
    private String image;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public List<String> getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getDesription() {
        return desription;
    }

    public String getImage() {
        return image;
    }
}