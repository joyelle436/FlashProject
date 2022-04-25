package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.PartData;

/**
 * Wordt geimplementeerd door {@link AnswerChoiceTextField} en {@link AnswerChoiceImage}
 */
public interface AnswerChoice {

    void setPosition(int position);
    /*
     Een andere vraag wordt toegevoegd of verwijderd
    */
    void changePosition(int position);
    void putInGridpane(PartData partData, TitledPaneGridpane gridpane, int position);
}
