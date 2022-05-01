package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.data.Part;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Subklasse van {@link AnswerChoiceTextField} en {@link AnswerChoiceImage}
 */
public class AnswerChoiceObject extends HBox implements EventHandler<ActionEvent> {

    protected TitledPaneGridpane gridpane;
    protected final CheckBox checkBox;
    protected final Button removeButton;
    public AnswerChoiceObject(TitledPaneGridpane gridpane){
        this.gridpane = gridpane;
        setSpacing(7);
        this.checkBox = new CheckBox();
        this.removeButton = new Button(" x ");
        removeButton.setOnAction(this);
        setMargin(removeButton, new Insets(6, 0, 0, 0));
        GridPane.setMargin(this, new Insets(0, 0, 0, 15));
    }

    public void setPosition(int position) {
        GridPane.setConstraints(this, 0, position);
    }

    public void putInGridpane(Part part, int position) {
        setPosition(position);
        gridpane.getChildren().add(this);
        gridpane.getOptionButton().increasePosition();
    }

    public void removeFromGridpane() {
        gridpane.getChildren().remove(this);
    }

    public void decreasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)-1);
    }

    public void increasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)+1);
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        removeFromGridpane();
    }
}