package be.ugent.flash.command;

import be.ugent.flash.command.databaseTools.DatabaseCollector;
import be.ugent.flash.command.databaseTools.DatabaseUpdater;
import be.ugent.flash.command.left.LeftController;
import be.ugent.flash.command.right.RightController;
import be.ugent.flash.db.Part;
import javafx.stage.Stage;

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
    private final Stage mainStage;

    public SidePaneConnection(MainBorderPane mainBorderPane, Map<Integer, String[]> questionMap, String database, Stage stage) throws SQLException {
        this.rightController = new RightController(this);
        this.leftController = new LeftController(this, questionMap);
        this.mainBorderPane = mainBorderPane;
        this.database = database;
        this.databaseCollector = new DatabaseCollector(database);
        this.databaseUpdater = new DatabaseUpdater(database);
        this.centerSplitPane = new CenterSplitPane(mainBorderPane, leftController.getLeftSidePane(), rightController.getRightSidePane());
        this.mainStage = stage;
    }

    public RightController getRightController() {
        return rightController;
    }

    public String getDatabase() {
        return database;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public DatabaseUpdater getDatabaseUpdater() {
        return databaseUpdater;
    }

    public void showPanes() {
        mainBorderPane.changeCenter(centerSplitPane);
    }
    /*
    Krijgt title van de LeftSidePane pane en vul gegevens aan in RightSidePane
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
        rightController.disableUndoAndSave(false);
    }

    public void enableTableView(){
        leftController.enableTable();
    }
    /**
     * Er wordt op de knop {@link be.ugent.flash.command.left.LeftBottomButton.AddQuestionButton} geklikt
     */
    public void addQuestion(String title, String type){
        databaseUpdater.addNewQuestion(title, type);
    }

    public void deleteQuestion(String title, String type) {
        databaseUpdater.deleteQuestion(title, type);
    }

    public void updateTableView(String title) {
        leftController.getLeftSidePane().getTableView().updateTableTitle(title);
    }
}