package be.ugent.flash.cardspanes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class MainTitledPane extends TitledPane {

    private final Label topMainLabel; /* beschrijt hoe de antwoorden eruit gaan uitzien */
    private final GridPane mainGridpane;
    public MainTitledPane(){
        this.topMainLabel = new Label("dlknfdksnfdksnf");
        this.mainGridpane = new GridPane();
        setFont(new Font(13));
        setPrefSize(545, 400);
        mainGridpane.setGridLinesVisible(true);
        GridPane.setConstraints(topMainLabel, 0, 0);
        mainGridpane.getChildren().add(topMainLabel);
        setContent(mainGridpane);
        setText("Mogelijke antwoorden");
        setCollapsible(false);
        BorderPane.setMargin(this, new Insets(0, 5, 0, 0));
    }

    public void setLabelText(String labelText) {
        topMainLabel.setText(labelText);
    }
}
