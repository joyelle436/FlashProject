package be.ugent.flash.command;

 import be.ugent.flash.command.lefts.LeftController;
import be.ugent.flash.command.rights.RightController;
import be.ugent.flash.data.Part;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Connectie tussen linkerkant en rechterkant van de beheersinterface
 */
public class SidePaneConnection {

    private final MainBorderPane mainBorderPane;
    private final RightController rightController;
    private final LeftController leftController;
    private final String database;
    private final DatabaseConnector databaseConnector;

    public SidePaneConnection(MainBorderPane mainBorderPane, Map<Integer, String[]> questionMap, String database) throws SQLException {
        this.rightController = new RightController(this);
        this.leftController = new LeftController(this, questionMap);
        this.mainBorderPane = mainBorderPane;
        this.database = database;
        this.databaseConnector = new DatabaseConnector(database);
        //SidePaneController sidePaneHandler = new SidePaneController();
    }

    public String getDatabase() {
        return database;
    }

    public void showPanes() {
        //this.databaseUpdater = new DatabaseUpdater(database);
        CenterSplitPane centerSplitPane = new CenterSplitPane();
        centerSplitPane.getItems().addAll(leftController.getLeftSidePane(), rightController.getRightSidePane());
        mainBorderPane.changeCenter(centerSplitPane); /* nu gaat de centerSplitPane definitief in de BorderPane blijven*/
    }
    /*
    Krijgt title uit de leftsidepane pane en vul gegevens aan in rightsidepane
     */
    public void showQuestionContent(String title, String type){
        rightController.showContent(databaseConnector.getQuestionContent(title), type);
    }

    public List<Part> showPartsContent(int question_id){
        return databaseConnector.getPartsContent(question_id);
    }


    public void disableTableView(){
        leftController.disableTable();
    }


    /*
        Als er op de knop <<Voeg nieuwe vraag toe>> geklikt wordt
         */
    public void addQuestion(QuestionData questionData){
    }

    /*
    Tegengestelde van addQuestion()
     */
    public void deleteQuestion(QuestionData questionData){
    }
}