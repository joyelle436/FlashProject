package be.ugent.flash.command.rights;

import be.ugent.flash.command.PictureButton;
import be.ugent.flash.command.TextInputListener;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * Gegevens van de {@link TopGridpane}
 */
public class TopContent implements TextInputListener {

    private final Label[] TOPLABELS; /* Staar bovenaan aan de rechterkant */
    private final Node[] NODETABLE;
    private final TextField titleField;
    private final TextArea textArea;
    private final Label typeLabel;
    private final TopGridpane topGridpane;
    public TopContent(TopGridpane topGridpane){
        this.topGridpane = topGridpane;
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
        PictureButton pictureButton = new PictureButton("Voeg afbeelding toe...");
        this.NODETABLE = new Node[]{
                titleField,
                typeLabel,
                textArea,
                pictureButton
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

    public void setTitleText(String title){
        titleField.setText(title);
    }

    public void setTypeText(String typeText){
        typeLabel.setText(typeText);
    }

    public void setQuestionText(String questionText){
        textArea.setText(questionText);
    }

    @Override
    public void addTextListener(){
        for (Node node : NODETABLE) {
            if(node instanceof TextInputControl){
                ((TextInputControl) node).textProperty().addListener((observable, oldtext, newtext) -> {
                    topGridpane.getRightController().getMainController().disableTableView();
                });
            }
        }
    }
}