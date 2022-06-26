package be.ugent.flash.command.right;


import be.ugent.flash.command.SidePaneConnection;
import be.ugent.flash.command.right.bottom.Save;
import be.ugent.flash.command.right.bottom.Undo;
import be.ugent.flash.db.Question;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class RightController {
    private final RightSidePane rightSidePane;
    private final RightPaneContent rightPaneContent;
    private final SidePaneConnection mainController;
    private final Label label;
    private Save save;
    private Undo undo;
    public RightController(SidePaneConnection controller){
        this.mainController = controller;
        this.rightSidePane = new RightSidePane(this);
        this.label = new Label("(geen vraag geselecteerd)");
        label.setAlignment(Pos.CENTER);
        rightSidePane.changeCenterChild(label);
        this.rightPaneContent = new RightPaneContent();
        rightSidePane.setRightPaneContent(rightPaneContent);
    }

    public void setSave(Save save) {
        this.save = save;
    }

    public void setUndo(Undo undo) {
        this.undo = undo;
    }

    public void disableUndoAndSave(boolean disable){
        save.setDisable(disable);
        undo.setDisable(disable);
    }

    public RightPaneContent getRightPaneContent() {
        return rightPaneContent;
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
        rightPaneContent.addContents(question, type);
    }
}