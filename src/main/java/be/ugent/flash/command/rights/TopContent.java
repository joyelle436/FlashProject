package be.ugent.flash.command.rights;

import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * Gegevens van de {@link TopGridpane}
 */
public class TopContent {

    private final Label[] TOPLABELS; /* Staar bovenaan aan de rechterkant */
    private final Node[] NODETABLE;
    private final TextField titleField;
    private final TextArea textArea;
    private final Label typeLabel;
    public TopContent(TopGridpane topGridpane){
        this.TOPLABELS = new Label[]{
                new Label("Titel"),/* -> Textfield */
                new Label("Type"),/* -> Label */
                new Label("Tekst"),/* -> TextField */
                new Label("Afbeelding")
        };
        this.titleField = new TextField();
        this.textArea = new TextArea();
        this.typeLabel = new Label("type Question");
        textArea.setPrefSize(575, 130);
        textArea.setWrapText(true);
        Button button = new Button("Voeg afbeelding toe...");
        button.setOnAction(actionEvent -> {
            //
        });
        this.NODETABLE = new Node[]{
                titleField,
                typeLabel,
                textArea,
                button
        };
    }
    /*
    Wordt in TopGridpane opgeroepen
     */
    public void addContent(){
        for(int index = 0; index < 4; index++){
            GridPane.setConstraints(TOPLABELS[index], 0, index);
            GridPane.setConstraints(NODETABLE[index], 1, index);
            GridPane.setValignment(TOPLABELS[index], VPos.TOP);
            TOPLABELS[index].setStyle("-fx-font-size: 13px");
            NODETABLE[index].setStyle("-fx-font-size: 13px");
        }
    }

    public Label[] getTopLabels() {
        return TOPLABELS;
    }

    public Node[] getNodeTable() {
        return NODETABLE;
    }

    public TextField getTitleField() {
        return titleField;
    }

    public TextArea getTextArea() {
        return textArea;
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