package danilem.app.com.moviesapp.Module;

import android.renderscript.Sampler;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("values")
    @Expose
    private List<Value> values = null;

    public List<Value> getValues() {
        return values;
    }

}
