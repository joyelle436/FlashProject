package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.TextInputListener;
import be.ugent.flash.data.Part;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;

import java.nio.charset.StandardCharsets;

/**
 * Voor mcs en mr
 */
public class AnswerChoiceTextArea extends AnswerChoiceObject implements TextInputListener {
    private final TextArea textArea;
    public AnswerChoiceTextArea(TitledPaneGridpane gridpane) {
        super(gridpane);
        setMargin(checkBox, new Insets(9, 0, 0, 0));
        this.textArea = new TextArea();
        textArea.setPrefSize(550, 40);
        getChildren().addAll(checkBox, textArea, removeButton);
    }

    public void addText(String text){
        textArea.setText(text);
    }

    public byte[] getStringPart(){
        return textArea.getText().getBytes(StandardCharsets.UTF_8);
    }

    public void putInGridpane(Part part, int position) {
        if(part != null){
            addText(new String(part.part()));
        }
        super.putInGridpane(part, position);
        addTextListener();
    }

    @Override
    public void addTextListener() {
        textArea.textProperty().addListener((observable, oldtext, newtext) -> {
            gridpane.getRightController().getMainController().disableTableView();
        });
    }
}
