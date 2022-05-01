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
    private final DatabaseCollector databaseCollector;
    private final DatabaseUpdater databaseUpdater;
    private final CenterSplitPane centerSplitPane;

    public SidePaneConnection(MainBorderPane mainBorderPane, Map<Integer, String[]> questionMap, String database) throws SQLException {
        this.rightController = new RightController(this);
        this.leftController = new LeftController(this, questionMap);
        this.mainBorderPane = mainBorderPane;
        this.database = database;
        this.databaseCollector = new DatabaseCollector(database);
        this.databaseUpdater = new DatabaseUpdater(database);
        this.centerSplitPane = new CenterSplitPane();
        //SidePaneController sidePaneHandler = new SidePaneController();
    }

    public RightController getRightController() {
        return rightController;
    }

    public String getDatabase() {
        return database;
    }

    public void showPanes() {
        centerSplitPane.getItems().addAll(leftController.getLeftSidePane(), rightController.getRightSidePane());
        mainBorderPane.changeCenter(centerSplitPane); /* nu gaat de centerSplitPane definitief in de BorderPane blijven*/
    }
    /*
    Krijgt title van de leftsidepane pane en vul gegevens aan in rightsidepane
     */
    public void showQuestionContent(String title, String type){
        rightController.showContent(databaseCollector.getQuestionContent(title), type);
    }

    public List<Part> showPartsContent(int question_id){
        return databaseCollector.getPartsContent(question_id);
    }

    public void unselectInTable(){
        leftController.unselectItems();
    }
    public void disableTableView(){
        leftController.disableTable();
    }

    public void enableTableView(){
        leftController.enableTable();
    }
    /*
    Er wordt op de knop <<Voeg nieuwe vraag toe>> geklikt
    */
    public void addQuestion(String title, String type){
        databaseUpdater.addNewQuestion(title, type);
    }


    public void deleteQuestion(String title, String type) {
        databaseUpdater.deleteQuestion(title, type);
    }
}