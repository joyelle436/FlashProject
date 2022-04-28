package be.ugent.flash.command.lefts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Map;

/**
 * Wordt opgeroept door {@link be.ugent.flash.command.lefts.LeftBottomButton.AddQuestionButton}
 */
public class AddDialogPane extends Stage implements EventHandler<ActionEvent> {

    private final Button okay;
    private final Button cancel;
    private final Titleline titleline;
    private final Typeline typeline;
    private final LeftBottomButton.AddQuestionButton addButton;
    public AddDialogPane(LeftBottomButton.AddQuestionButton addButton){
        this.addButton = addButton;
        this.okay = new Button("OK");
        okay.setOnAction(this);
        this.cancel = new Button("Annuleren");
        cancel.setOnAction(actionEvent -> {
            close();
        });
        Label dialogTitel = new Label("Nieuwe vraag toevoegen");
        BorderPane.setMargin(dialogTitel, new Insets(0, 0, 0, 40));
        dialogTitel.setFont(new Font(18));
        dialogTitel.setStyle("-fx-font-weight: bold");
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setPrefSize(350, 115);
        vBox.setSpacing(5);
        BorderPane.setMargin(vBox, new Insets(5, 0, 0, 0));
        titleline = new Titleline();
        typeline = new Typeline();
        HBox buttonsHbox = new HBox(okay, cancel);
        buttonsHbox.setSpacing(5);
        VBox.setMargin(buttonsHbox, new Insets(0, 0, 0, 63));
        vBox.getChildren().addAll(titleline, typeline, buttonsHbox);
        borderPane.setTop(dialogTitel);
        borderPane.setCenter(vBox);
        setScene(new Scene(borderPane, Color.TRANSPARENT));
        initStyle(StageStyle.TRANSPARENT);
        centerOnScreen();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        addButton.addNewQuestion(titleline.textField.getText(),
                typeline.choiceBox.getSelectionModel().getSelectedItem());
        close();
    }

    public static class Titleline extends HBox {
        private final Label label;
        private final TextField textField;
        public Titleline(){
            this.label = new Label("Titel");
            HBox.setMargin(label, new Insets(0, 0, 0, 7));
            this.textField = new TextField();
            HBox.setMargin(textField, new Insets(0, 0, 0, 2.5));
            textField.setPrefWidth(230);
            setSpacing(30);
            getChildren().addAll(label, textField);
        }
    }

    public static class Typeline extends HBox{
        private final Label label;
        private final ChoiceBox<String> choiceBox;
        public Typeline(){
            this.label = new Label("Type");
            HBox.setMargin(label, new Insets(0, 0, 0, 7));
            this.choiceBox = new ChoiceBox<>();
            choiceBox.setPrefWidth(230);
            choiceBox.getItems().addAll(
                    "Meerkeuze (standaard)",
                    "Meerkeuze (compact)",
                    "Meerkeuze (afbeeldingen)",
                    "Meerantwoord",
                    "Open (tekst)",
                    "Open (geheel)"
            );
            choiceBox.getSelectionModel().selectFirst();
            getChildren().addAll(label, choiceBox);
            setSpacing(30);
        }
    }
}