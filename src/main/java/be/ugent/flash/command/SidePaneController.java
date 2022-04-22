package be.ugent.flash.command;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.panels.OpenQuestionPane;
import be.ugent.flash.panels.QuestionPane;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

import java.util.List;

/**
 * Connectie tussen linkerkant en rechterkant van de beheersinterface
 */
public class SidePaneController {

    private final MainBorderPane mainBorderPane;
    private final RightSidePane rightSidePane;
    private final LeftSidePane leftSidePane;
    private final List<QuestionData> questionDataList;
    private final List<PartData> partDataList;
    private final CommandMapMaker mapMaker;

    public SidePaneController(MainBorderPane mainBorderPane, List<QuestionData> questionDataList, List<PartData> partDataList) {
        this.questionDataList = questionDataList;
        this.partDataList = partDataList;
        this.rightSidePane = new RightSidePane(this);
        this.leftSidePane = new LeftSidePane(this);
        this.mainBorderPane = mainBorderPane;
        this.mapMaker = new CommandMapMaker();
        mapMaker.makePanesMap();
    }

    public void showPanes() {
        rightSidePane.fillRightPane();
        leftSidePane.fillLeftPane(questionDataList);
        CenterSplitPane centerSplitPane = new CenterSplitPane();
        centerSplitPane.getItems().addAll(leftSidePane, rightSidePane);
        mainBorderPane.changeCenter(centerSplitPane);
    }
    /*
    Krijgt title uit de leftsidepane pane en vul gegevens aan in leftsidepane
     */
    public void showQuestionContent(String title){
        rightSidePane.getTopGridpane().setVisible(true);
        String type = "";
        for(QuestionData questionData: questionDataList){
            if(questionData.getTitle().equals(title)){
                type = questionData.getQuestionType();
                rightSidePane.getTopGridpane().addToTopContent(questionData);
            }
        }
        QuestionPane pane = mapMaker.getQuestionPane(type);
        pane.setRightSidePane(rightSidePane);
        pane.fill();
        BorderPane.setMargin(pane, new Insets(15));
        rightSidePane.getContentBorderpane().changeCenterChild(pane);

        /* maar ook nieuwe object uit panels maken */
    }
    /*
    Als er op de knop <<Voeg nieuwe vraag toe>> geklikt wordt
     */
    public void addQuestion(){
    }

    /*
    Tegengestelde van addQuestion()
     */
    public void deleteQuestion(){
    }
}
