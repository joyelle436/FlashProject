package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public abstract class Type extends VBox {
    protected TextFlow textFlow;
    protected Text text;

    public Type(){
        setId("questionVbox");
        setAlignment(Pos.TOP_CENTER);
        textFlow = new TextFlow();
        textFlow.setId("textflow");
        setMargin(textFlow, new Insets(130, 0, 0, 0));
        textFlow.setPadding(new Insets(0, 15, 15, 20));
        text = new Text();
        text.setId("text");
        textFlow.getChildren().add(text);
        getChildren().addAll(textFlow);
    }
}
