package be.ugent.flash.command.rights;


import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.command.SidePaneConnection;
import be.ugent.flash.data.Question;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class RightController {
    private final RightSidePane rightSidePane;
    private final RightPaneContent rightPaneData;
    private final SidePaneConnection mainController;
    private final CommandMapMaker mapMaker;
    private final Label label;
    public RightController(SidePaneConnection controller){
        this.mainController = controller;
        this.rightSidePane = new RightSidePane(this);
        this.label = new Label("(geen vraag geselecteerd)");
        label.setAlignment(Pos.CENTER);
        rightSidePane.changeCenterChild(label);
        this.rightPaneData = new RightPaneContent();
        rightSidePane.setRightPaneContent(rightPaneData);
        this.mapMaker = new CommandMapMaker();
    }

    public String getDatabase(){
        return mainController.getDatabase();
    }

    public void setLabelToCenter() {
        rightSidePane.getChildren().clear();
        rightSidePane.changeCenterChild(label);
    }

    public SidePaneConnection getMainController() {
        return mainController;
    }

    public RightSidePane getRightSidePane() {
        return rightSidePane;
    }

    public void showContent(Question question, String type){
        /* questionData + lijst van PartData voor die specifieke vraag*/
        rightPaneData.addContents(question, type);
    }
}