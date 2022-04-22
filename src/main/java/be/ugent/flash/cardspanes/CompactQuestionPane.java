package be.ugent.flash.cardspanes;


import be.ugent.flash.command.RightSidePane;

public class CompactQuestionPane extends QuestionPane {
    public CompactQuestionPane(){
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
