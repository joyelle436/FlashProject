package be.ugent.flash.command.right.bottom;

import be.ugent.flash.cardspanes.CardPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Preview extends BottomButton implements EventHandler<MouseEvent> {

    private QuestionPreview questionPreview;
    public Preview(CardPane cardPane) {
        super(cardPane);
        setText("Preview");
        setOnMousePressed(this);
        setOnMouseReleased(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_PRESSED)){
            // open de stage en toont de kaart
            this.questionPreview = new QuestionPreview(cardPane);
            questionPreview.showPreview();
        }

        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_RELEASED)){
            //sluit de stage
            questionPreview.close();
        }
    }
}