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
    private final CenterTitledPane centerTitledPane;
    public OptionButton(CenterTitledPane centerTitledPane){
        super("Optie toevoegen");
        this.centerTitledPane = centerTitledPane;
        GridPane.setConstraints(this, 0, 1);
        GridPane.setMargin(this, new Insets(0, 0, 10, 10));
    }

    /*
     Een andere vraag wordt toegevoegd of verwijderd
    */
    public void decreasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)-1);
    }

    public void increasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)+1);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    }
}
