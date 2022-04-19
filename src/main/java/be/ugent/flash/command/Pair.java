package be.ugent.flash.command;

import javafx.beans.property.*;

/**
 * Bron {@link <a href="https://openjfx.io/javadoc/17/javafx.controls/javafx/scene/control/TableView.html">...</a>}
 */
public class Pair {

    private StringProperty title;
    private StringProperty type;

    public void setTitle(String title) {
        titleProperty().set(title);
    }

    public void setType(String type) {
        typeProperty().set(type);
    }

    public String getTitle() {
        return titleProperty().get();
    }

    public String getType() {
        return typeProperty().get();
    }

    public StringProperty titleProperty(){
        if(title == null){
            title = new SimpleStringProperty(this, "title");
        }
        return title;
    }


    public StringProperty typeProperty(){
        if(type == null){
            type = new SimpleStringProperty(this, "type");
        }
        return type;
    }
    public Pair(String title, String type){
        setTitle(title);
        setType(type);
    }
}