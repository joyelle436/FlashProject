package be.ugent.flash.cardspanes;

import be.ugent.flash.command.AnswerChoiceTextField;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class MainTitledPane extends TitledPane {

    private final TopDescriptionLabel descriptionLabel; /* beschrijt hoe de antwoorden eruit gaan uitzien */
    private final TitledPaneGridpane mainGridpane;
    public MainTitledPane(){
        this.descriptionLabel = new TopDescriptionLabel();
        this.mainGridpane = new TitledPaneGridpane();
        setFont(new Font(13));
        setPrefSize(545, 400);
        AnswerChoiceTextField textField = new AnswerChoiceTextField();
        AnswerChoiceTextField textField1 = new AnswerChoiceTextField();
        GridPane.setConstraints(textField, 0, 1);
        GridPane.setConstraints(textField1, 0, 2);
        mainGridpane.getChildren().add(descriptionLabel);
        setContent(mainGridpane);
        setText("Mogelijke antwoorden");
        setCollapsible(false);
        BorderPane.setMargin(this, new Insets(0, 5, 0, 0));
    }

    public void setLabelText(String labelText) {
        descriptionLabel.setText(labelText);
    }

    public void addChoiceTextField(String text){
        AnswerChoiceTextField choiceTextField = new AnswerChoiceTextField();
        choiceTextField.addText(text);
        mainGridpane.addTextField(choiceTextField);
    }

    private static class TopDescriptionLabel extends Label {
        public TopDescriptionLabel(){
            super();
            setFont(new Font(11));
            setLineSpacing(2);
            setStyle("-fx-text-fill: #888888");
            GridPane.setMargin(this, new Insets(5));
            GridPane.setConstraints(this, 0, 0);
        }
    }
}