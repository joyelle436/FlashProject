package be.ugent.flash.command.right;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.data.Part;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import java.nio.charset.StandardCharsets;

/**
 * Voor mcc
 */
public class AnswerChoiceTextField extends AnswerChoiceObject implements TextInputListener {
    private final TextField textField;
    public AnswerChoiceTextField(TitledPaneGridpane gridpane){
        super(gridpane);
        setMargin(checkBox, new Insets(9, 0, 0, 0));
        this.textField = new TextField();
        textField.setPrefSize(550, 40);
        getChildren().addAll(checkBox, textField, removeButton);
    }

    public void addText(String text){
        textField.setText(text);
    }

    public byte[] getStringPart(){
        return textField.getText().getBytes(StandardCharsets.UTF_8);
    }

    public void putInGridpane(Part part, int position) {
        if(part != null && part.part() != null){
            addText(new String(part.part()));
        }
        super.putInGridpane(part, position);
        addTextListener();
    }

    @Override
    public void addTextListener() {
        textField.textProperty().addListener((observable, oldtext, newtext) -> {
            gridpane.getRightController().getMainController().disableTableView();
        });
    }
}