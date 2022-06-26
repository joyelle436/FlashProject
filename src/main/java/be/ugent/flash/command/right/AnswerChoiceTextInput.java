package be.ugent.flash.command.right;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.db.Part;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import java.nio.charset.StandardCharsets;

public class AnswerChoiceTextInput extends AnswerChoiceObject implements TextInputListener {

    protected TextInputControl textInputControl;

    public AnswerChoiceTextInput(TitledPaneGridpane gridpane){
        super(gridpane);
        setMargin(checkBox, new Insets(9, 0, 0, 0));
    }

    public void addText(String text){
        textInputControl.setText(text);
    }

    public byte[] getStringPart(){
        return textInputControl.getText().getBytes(StandardCharsets.UTF_8);
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
        textInputControl.textProperty().addListener((observable, oldtext, newtext) -> {
            gridpane.getRightController().getMainController().disableTableView();
        });
    }

    /**
     * mcs en mr
     */

    public static class AnswerChoiceTextArea extends AnswerChoiceTextInput {
        public AnswerChoiceTextArea(TitledPaneGridpane gridpane) {
            super(gridpane);
            this.textInputControl = new TextArea();
            textInputControl.setPrefSize(550, 40);
            getChildren().addAll(checkBox, textInputControl, removeButton);
        }
    }

    /**
     * mcc
     */
    public static class AnswerChoiceTextField extends AnswerChoiceTextInput {
        public AnswerChoiceTextField(TitledPaneGridpane gridpane){
            super(gridpane);
            this.textInputControl = new TextField();
            textInputControl.setPrefSize(550, 40);
            getChildren().addAll(checkBox, textInputControl, removeButton);
        }
    }
}
