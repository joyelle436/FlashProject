package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RightSidePane;

public class MultipleQuestionPane extends QuestionPane {
    public MultipleQuestionPane(){
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        super.setRightSidePane(rightSidePane);
        createTitledPane();
    }

    public void fill(){
        super.fill();
        addBottomButtons();
    }
}
