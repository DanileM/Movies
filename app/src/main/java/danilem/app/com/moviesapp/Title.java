package danilem.app.com.moviesapp;

import java.util.ArrayList;

public class Title {

    public static final int TITLE_TYPE = 0;
    public static final int CHECKBOXES_TYPE = 1;

    private String title;
    private int type;

    public Title(String title, int type){
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
