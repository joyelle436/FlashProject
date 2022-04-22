package be.ugent.flash.command;


import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.cardspanes.CardPane;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class RightController {

    private final RightSidePane rightSidePane;
    private final CommandMapMaker mapMaker;
    public RightController(SidePaneController controller){
        this.rightSidePane = new RightSidePane(controller);
        rightSidePane.fillRightPane();
        this.mapMaker = new CommandMapMaker();
        mapMaker.makePanesMap();
    }

    public RightSidePane getRightSidePane() {
        return rightSidePane;
    }

    public void showContent(QuestionData questionData){
        rightSidePane.getTopGridpane().setVisible(true);
        rightSidePane.getTopGridpane().addToTopContent(questionData);
        CardPane pane = mapMaker.getQuestionPane(questionData.getQuestionType());
        pane.setRightSidePane(rightSidePane);
        pane.fill();
        pane.setCorrectTextField(questionData.getCorrectAnswer());
        BorderPane.setMargin(pane, new Insets(15));
        rightSidePane.changeCenterChild(pane);
    }
}
