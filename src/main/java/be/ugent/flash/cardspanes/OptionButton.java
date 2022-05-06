package be.ugent.flash.cardspanes;

import be.ugent.flash.command.right.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Staat onderaan de {@link TitledPaneGridpane}
 */
public class OptionButton extends Button implements EventHandler<ActionEvent> {

    private final TitledPaneGridpane gridpane;
    public OptionButton(TitledPaneGridpane gridpane){
        super("Optie toevoegen");
        this.gridpane = gridpane;
        GridPane.setConstraints(this, 0, 1);
        GridPane.setMargin(this, new Insets(0, 0, 10, 10));
        setOnAction(this);
    }

    /*
     Een andere vraag wordt toegevoegd of verwijderd
    */
    public void decreasePosition() {
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)-1);
    }

    public void increasePosition() {
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)+1);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        AnswerChoiceObject choiceObject;
        if (gridpane.getQuestionType().equals("mci")) {
            choiceObject = new AnswerChoiceImage(gridpane);
        } else if(gridpane.getQuestionType().equals("mcc")){
            choiceObject = new AnswerChoiceTextInput.AnswerChoiceTextField(gridpane);
        } else {
            choiceObject = new AnswerChoiceTextInput.AnswerChoiceTextArea(gridpane);
        }
        choiceObject.putInGridpane(null, gridpane.getRowPosition());
        gridpane.setRowPosition(gridpane.getRowPosition()+1);
    }
}