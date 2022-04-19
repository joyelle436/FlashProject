package be.ugent.flash.command;

import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.*;

import javafx.scene.layout.*;

import java.util.Objects;

/**
 * Staat boven de {@link RightSidePane}
 */
public class TopGridpane extends GridPane {

    private final Label[] TOPLABELS;
    private final Node[] NODETABLE;
    private final TextField titleField;
    private final TextArea textArea;
    private final Label typeLabel;
    public TopGridpane(){
        this.TOPLABELS = new Label[]{
                new Label("Titel"),/* -> Textfield */
                new Label("Type"),/* -> Label */
                new Label("Tekst"),/* -> TextField */
                new Label("Afbeelding")
        };
        this.titleField = new TextField();
        this.textArea = new TextArea();
        this.typeLabel = new Label("type Question");
        textArea.setPrefSize(575, 150);
        textArea.setWrapText(true);
        this.NODETABLE = new Node[]{
                titleField,
                typeLabel,
                textArea,
                new Button("Voeg afbeelding toe...")
        };
        setAlignment(Pos.TOP_CENTER);
        BorderPane.setMargin(this, new Insets(15));
        setVgap(7);
        setHgap(15);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void fillGridpane(){
        getChildren().addAll(TOPLABELS);
        getChildren().addAll(NODETABLE);
        for(int index = 0; index < 4; index++){
            GridPane.setConstraints(TOPLABELS[index], 0, index);
            GridPane.setConstraints(NODETABLE[index], 1, index);
            GridPane.setValignment(TOPLABELS[index], VPos.TOP);
            TOPLABELS[index].setStyle("-fx-font-size: 13px");
            NODETABLE[index].setStyle("-fx-font-size: 13px");
        }
        getColumnConstraints().addAll(new ColumnConstraints(80), new ColumnConstraints(575));
    }

    public void setTitleText(String title){
        titleField.setText(title);
    }

    public void setTypeText(String typeText){
        typeLabel.setText(typeText);
    }

    public void setQuestionText(String questionText){
        textArea.setText(questionText);
    }
}
