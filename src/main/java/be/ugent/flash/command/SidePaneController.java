package be.ugent.flash.command;

import be.ugent.flash.CommandMapMaker;

import java.util.List;

/**
 * Connectie tussen linkerkant en rechterkant van de beheersinterface
 */
public class SidePaneController {

    private final MainBorderPane mainBorderPane;
    private final RightController rightController;
    private final LeftController leftController;
    private final List<QuestionData> questionDataList;
    private final List<PartData> partDataList;
    private final CommandMapMaker mapMaker;

    public SidePaneController(MainBorderPane mainBorderPane, List<QuestionData> questionDataList, List<PartData> partDataList) {
        this.rightController = new RightController(this);
        this.leftController = new LeftController(this, questionDataList);
        this.questionDataList = questionDataList;
        this.partDataList = partDataList;
        this.mainBorderPane = mainBorderPane;
        this.mapMaker = new CommandMapMaker();
        mapMaker.makePartDataMap(partDataList);
    }

    public void showPanes() {
        CenterSplitPane centerSplitPane = new CenterSplitPane();
        centerSplitPane.getItems().addAll(leftController.getLeftSidePane(), rightController.getRightSidePane());
        mainBorderPane.changeCenter(centerSplitPane);
    }
    /*
    Krijgt title uit de leftsidepane pane en vul gegevens aan in leftsidepane
     */
    public void showQuestionContent(String title){
        QuestionData questionData = questionDataList.get(0);
        int index = 1;
        while(index < questionDataList.size() &&
                !questionData.getTitle().equals(title)){
            questionData = questionDataList.get(index);
            index += 1;
        }
        rightController.showContent(questionData, mapMaker.getPartData(questionData.getId()));
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