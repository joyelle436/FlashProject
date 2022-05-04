package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.data.Part;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Subklasse van {@link AnswerChoiceTextField}, {@link AnswerChoiceTextArea} en {@link AnswerChoiceImage}
 */
public class AnswerChoiceObject extends HBox {

    protected TitledPaneGridpane gridpane;
    protected final CheckBox checkBox;
    protected final Button removeButton;
    protected int part_id;
    public AnswerChoiceObject(TitledPaneGridpane gridpane){
        this.gridpane = gridpane;
        this.part_id = Integer.MAX_VALUE; //als dit nog niet in de databank staat
        setSpacing(7);
        this.checkBox = new CheckBox();
        this.removeButton = new Button(" x ");
        removeButton.setOnAction(actionEvent -> {
            removeFromGridpane();
        });
        setMargin(removeButton, new Insets(6, 0, 0, 0));
        GridPane.setMargin(this, new Insets(0, 0, 0, 15));
    }

    public boolean isSelected(){
        return checkBox.isSelected();
    }

    public String getStringPart(){
        return "";
    }

    public void setPosition(int position) {
        GridPane.setConstraints(this, 0, position);
    }

    public void putInGridpane(Part part, int position) {
        this.part_id = part.part_id();
        setPosition(position);
        gridpane.getChildren().add(this);
        gridpane.putInSet(this);
        gridpane.getOptionButton().increasePosition();
    }

    public void removeFromGridpane() {
        gridpane.getOptionButton().decreasePosition();
        gridpane.changeChildrenPosition(GridPane.getRowIndex(this));
        gridpane.setRowPosition(gridpane.getRowPosition()-1);
        gridpane.removeFromSet(this);
        gridpane.getChildren().remove(this);
    }

    public void decreasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)-1);
    }
}