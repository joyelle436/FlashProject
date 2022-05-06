package be.ugent.flash.command;

import be.ugent.flash.data.DataCollector;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.*;

public class FileDataCollector {

    protected final MainBorderPane startWindow;
    protected final Stage stage;
    public FileDataCollector(MainBorderPane startWindow){
        this.stage = startWindow.getStage();
        this.startWindow = startWindow;
    }

    /* Voor DatabaseOpener */
    public void getFile(){
    }

    /* Voor DatabaseMaker */
    public void createFile(){
    }

    public void getFileData(String database) throws SQLException {
        DataCollector dataCollector = new DataCollector(database);
        List<Question> questionList = dataCollector.getQuestionsData(); /* alle gegevens uit questions */
        Map<Integer, String[]> questionMap = new HashMap<>();
        /*
          Een map met een question_id afgebeeld op zijn overeenkomstige {title, type}
         */
        for(Question question: questionList){
            questionMap.put(question.id(), new String[]{question.title(), question.questionType()});
        }
        dataCollector.closeDAC();
        stage.setTitle(database);
        new SidePaneConnection(startWindow, questionMap, database, stage).showPanes();
    }
}