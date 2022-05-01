package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.RightController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class CenterTitledPane extends TitledPane {

    private final TopDescriptionLabel descriptionLabel; /* beschrijt hoe de antwoorden eruit gaan uitzien */
    private final TitledPaneGridpane mainGridpane;
    public CenterTitledPane(String questionType, RightController rightController){
        this.descriptionLabel = new TopDescriptionLabel();
        this.mainGridpane = new TitledPaneGridpane(questionType, rightController);
        /*Bevat de mainGridpane*/
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxHeight(400);
        scrollPane.setContent(mainGridpane);
        setFont(new Font(13));
        mainGridpane.getChildren().add(descriptionLabel);
        setContent(scrollPane);
        setText("Mogelijke antwoorden");
        BorderPane.setMargin(this, new Insets(0, 5, 0, 0));
    }

    public TitledPaneGridpane getMainGridpane() {
        return mainGridpane;
    }

    public void setLabelText(String labelText) {
        descriptionLabel.setText(labelText);
    }

    private static class TopDescriptionLabel extends Label {
        public TopDescriptionLabel(){
            setFont(new Font(11));
            setLineSpacing(2);
            setStyle("-fx-text-fill: #888888");
            GridPane.setMargin(this, new Insets(10));
            GridPane.setConstraints(this, 0, 0);
        }
    }
}