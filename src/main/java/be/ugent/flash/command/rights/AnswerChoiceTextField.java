package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.PositionChanger;
import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.PartData;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Dit is alleen voor mcs, mcc en mr vragen
 */
public class AnswerChoiceTextField extends HBox implements AnswerChoice, PositionChanger {
    private final CheckBox checkBox;
    private final TextField textField;
    private final Button removeButton;
    private final TitledPaneGridpane gridpane;
    public AnswerChoiceTextField(TitledPaneGridpane gridpane){
        this.gridpane = gridpane;
        this.checkBox = new CheckBox();
        setMargin(checkBox, new Insets(9, 0, 0, 0));
        this.textField = new TextField();
        textField.setPrefSize(550, 40);
        this.removeButton = new Button(" x ");
        removeButton.setOnAction(this);
        setMargin(removeButton, new Insets(6, 0, 0, 0));
        setSpacing(7);
        getChildren().addAll(checkBox, textField, removeButton);
        GridPane.setMargin(this, new Insets(0, 0, 0, 15));
    }

    public void addText(String text){
        textField.setText(text);
    }

    @Override
    public void setPosition(int position) {
        GridPane.setConstraints(this, 0, position);
    }

    @Override
    public void putInGridpane(PartData partData, int position) {
        if(partData != null){
            addText(new String(partData.getPart()));
        }
        setPosition(position);
        gridpane.getChildren().add(this);
        gridpane.getOptionButton().increasePosition();
    }

    @Override
    public void removeFromGridpane() {
        gridpane.removeFromSet(this);
        gridpane.getChildren().remove(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gridpane.setRowPosition(gridpane.getRowPosition()-1);
        removeFromGridpane();
    }

    @Override
    public void decreasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)-1);
    }

    @Override
    public void increasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)+1);
    }

    @Override
    public void changePosition(int index) {
        if(index < GridPane.getRowIndex(this)){
            decreasePosition();
            gridpane.setRowPosition(gridpane.getRowPosition()-1);
        }
    }
}
