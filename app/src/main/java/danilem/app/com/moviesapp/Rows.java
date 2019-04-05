package danilem.app.com.moviesapp;

public class Rows extends ListItem {
    String row;
    private boolean isSelected;

    public Rows(String row) {
        this.row = row;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
