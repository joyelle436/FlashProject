package be.ugent.flash.command;

import be.ugent.flash.data.*;
import javafx.scene.control.ScrollPane;

import java.util.List;

/**
 * Verandert componenten van de Borderpane die op de scene staat
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

    public void showContent() {
        mainBorderPane.getChildren().remove(mainBorderPane.getCenter());
        CenterSplitPane centerSplitPane = new CenterSplitPane();
        LeftSidePane leftSidePane = new LeftSidePane();

        RightSidePane rightSidePane = new RightSidePane();
        rightSidePane.fillBorderpane();

        leftSidePane.getTableView().addColumnsData(questionList);
        centerSplitPane.getItems().addAll(leftSidePane, rightSidePane);
        mainBorderPane.setCenter(centerSplitPane);
    }
}
