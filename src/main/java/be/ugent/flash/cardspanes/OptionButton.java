package be.ugent.flash.cardspanes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Staat onderaan de {@link TitledPaneGridpane}
 */
public class OptionButton extends Button implements EventHandler<ActionEvent> {
    public OptionButton(){
        super("Optie toevoegen");
        GridPane.setConstraints(this, 0, 1);
        GridPane.setMargin(this, new Insets(0, 0, 0, 10));
    }

    /*
     Een andere vraag wordt toegevoegd of verwijderd
    */
    public void changeButtonPosition(int position){
        GridPane.setConstraints(this, 0, position);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    }
}
