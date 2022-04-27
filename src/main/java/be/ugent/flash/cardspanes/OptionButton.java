package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Staat onderaan de {@link TitledPaneGridpane}
 */
public class OptionButton extends Button implements EventHandler<ActionEvent> {
    private final TitledPaneGridpane gridpane;

    public OptionButton(TitledPaneGridpane gridpane) {
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
        GridPane.setRowIndex(this, GridPane.getRowIndex(this) - 1);
    }

    public void increasePosition() {
        GridPane.setRowIndex(this, GridPane.getRowIndex(this) + 1);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        AnswerChoiceObject choiceObject;
        if (gridpane.getQuestionType().equals("mci")) {
            choiceObject = new AnswerChoiceImage(gridpane);
        } else {
            choiceObject = new AnswerChoiceTextField(gridpane);
        }
        choiceObject.putInGridpane(null, gridpane.getRowPosition());
        gridpane.setRowPosition(gridpane.getRowPosition()+1);
    }
}