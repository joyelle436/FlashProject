package be.ugent.flash.command;

import be.ugent.flash.data.*;
import javafx.scene.layout.StackPane;

import java.util.List;

/**
 * Verandert children van de Borderpane die op de scene staat
 */
public class PaneOpener {

    private final MainBorderPane mainBorderPane;
    private final List<Question> questionList;
    private final List<Part> partList;
    public PaneOpener(MainBorderPane startWindow, List<Question> questionList, List<Part> partList){
        this.mainBorderPane = startWindow;
        this.questionList = questionList;
        this.partList = partList;
    }

    public void showList() {
        mainBorderPane.getChildren().remove(mainBorderPane.getCenter());
        CenterSplitPane centerSplitPane = new CenterSplitPane();
        LeftPane leftGridPane = new LeftPane();
        leftGridPane.getTableView().addColumnsData(questionList);
        centerSplitPane.getItems().addAll(leftGridPane, new StackPane());
        mainBorderPane.setCenter(centerSplitPane);
    }
}
