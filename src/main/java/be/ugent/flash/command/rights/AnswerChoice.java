package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.PartData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Wordt geimplementeerd door {@link AnswerChoiceTextField} en {@link AnswerChoiceImage}
 */
public interface AnswerChoice extends EventHandler<ActionEvent> {

    void setPosition(int position);
    /*
     Een andere vraag wordt toegevoegd of verwijderd
    */
    void putInGridpane(PartData partData, int position);
    void removeFromGridpane();
}
