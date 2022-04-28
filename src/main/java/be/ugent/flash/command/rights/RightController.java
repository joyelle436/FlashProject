package be.ugent.flash.command.rights;


import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.command.SidePaneConnection;
import be.ugent.flash.data.Question;

public class RightController {
    private final RightSidePane rightSidePane;
    private final RightPaneContent rightPaneData;
    private SidePaneConnection mainController;
    private final CommandMapMaker mapMaker;
    public RightController(SidePaneConnection controller){
        this.mainController = controller;
        this.rightSidePane = new RightSidePane(this);
        rightSidePane.fillRightPane();
        this.rightPaneData = new RightPaneContent();
        rightSidePane.setRightPaneContent(rightPaneData);
        this.mapMaker = new CommandMapMaker();
    }

    public String getDatabase(){
        return mainController.getDatabase();
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
