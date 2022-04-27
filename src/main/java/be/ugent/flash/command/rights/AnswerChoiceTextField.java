package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.PartData;
import javafx.geometry.Insets;
import javafx.scene.control.*;

/**
 * Dit is alleen voor mcs, mcc en mr vragen
 */
public class AnswerChoiceTextField extends AnswerChoiceObject {
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

    public void putInGridpane(PartData partData, int position) {
        if(partData != null){
            addText(new String(partData.getPart()));
        }
        super.putInGridpane(partData, position);
    }
}