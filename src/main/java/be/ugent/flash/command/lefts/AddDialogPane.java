package be.ugent.flash.command.lefts;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Wordt opgeroept door {@link be.ugent.flash.command.lefts.LeftBottomButton.AddQuestionButton}
 */
public class AddDialogPane extends Stage {

    private final Button okay;
    private final Button cancel;
    public AddDialogPane(){
        this.okay = new Button("OK");
        this.cancel = new Button("Annuleren");
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        Titleline titleline = new Titleline();
        Typeline typeline = new Typeline();
        HBox buttonsHbox = new HBox(okay, cancel);
        buttonsHbox.setSpacing(5);
        vBox.getChildren().addAll(titleline, typeline, buttonsHbox);
    }

    public static class Titleline extends HBox {
        private final Label label;
        private final TextField textField;
        public Titleline(){
            this.label = new Label("Titel");
            this.textField = new TextField();
        }
    }

    public static class Typeline extends HBox{
        private final Label label;
        private final ChoiceBox<String> choiceBox;
        public Typeline(){
            this.label = new Label("Type");
            this.choiceBox = new ChoiceBox<>();
        }
    }
}