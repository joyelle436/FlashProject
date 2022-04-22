package be.ugent.flash.command;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Gegevens van de {@link TopGridpane}
 */
public class TopContent {

    private final Label[] TOPLABELS;
    private final Node[] NODETABLE;
    private final TextField titleField;
    private final TextArea textArea;
    private final Label typeLabel;

    public TopContent(){
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
}
