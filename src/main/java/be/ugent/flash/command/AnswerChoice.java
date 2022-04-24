package be.ugent.flash.command;

/**
 * Wordt geimplementeerd door {@link AnswerChoiceTextField} en {@link AnswerChoiceImage}
 */
public interface AnswerChoice {

    void setPosition(int position);
    /*
     Een andere vraag wordt toegevoegd of verwijderd
    */
    void changePosition(int position);
}
