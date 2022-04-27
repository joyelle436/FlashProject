package be.ugent.flash.command;

import be.ugent.flash.command.lefts.LeftController;
import be.ugent.flash.command.rights.RightController;
import be.ugent.flash.handlers.SidePaneHandler;

import java.util.List;

/**
 * Connectie tussen linkerkant en rechterkant van de beheersinterface
 */
public class SidePaneController {

    private final MainBorderPane mainBorderPane;
    private final RightController rightController;
    private final LeftController leftController;
    private final List<QuestionData> questionDataList;
    private final SidePaneHandler sidePaneHandler;
    private DatabaseUpdater databaseUpdater;

    public SidePaneController(MainBorderPane mainBorderPane, List<QuestionData> questionDataList, List<PartData> partDataList) {
        this.rightController = new RightController(this, partDataList);
        this.leftController = new LeftController(this, questionDataList);
        this.questionDataList = questionDataList;
        this.mainBorderPane = mainBorderPane;
        this.sidePaneHandler = new SidePaneHandler();
    }

    public void showPanes(String database) {
        this.databaseUpdater = new DatabaseUpdater(database);
        CenterSplitPane centerSplitPane = new CenterSplitPane();
        centerSplitPane.getItems().addAll(leftController.getLeftSidePane(), rightController.getRightSidePane());
        mainBorderPane.changeCenter(centerSplitPane); /* nu gaat de centerSplitPane definitief in de BorderPane blijven*/
    }
    /*
    Krijgt title uit de leftsidepane pane en vul gegevens aan in rightsidepane
     */
    public void showQuestionContent(String title){
        rightController.showContent(sidePaneHandler.getQToShow(questionDataList, title));
    }

    public QuestionData getTheQuestionData(int id) {
        int index = 0;
        while(questionDataList.get(index).getId() != id){
            index++;
        }
        return questionDataList.get(index);
    }

    /*
        Er wordt op de opslaan knop geklikt
         */
    public void updateQuestion(int questionId, QuestionData questionData){
        /* dit ook aan rightsidepane doorgeven om partDataList te updaten */
        int index = 0;
        while(questionDataList.get(index).getId() != questionData.getId()){
            index++;
        }
        questionDataList.set(index, questionData);
        databaseUpdater.updateQuestion(questionId, questionData);
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