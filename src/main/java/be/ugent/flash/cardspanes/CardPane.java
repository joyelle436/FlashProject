package be.ugent.flash.cardspanes;

import be.ugent.flash.command.*;
import be.ugent.flash.command.rights.*;
import be.ugent.flash.events.TitledPaneFiller;
import javafx.geometry.*;
import javafx.scene.layout.*;

import java.util.List;

public class CardPane extends VBox {
    protected RightSidePane rightSidePane;
    protected final ButtonHBox buttonHBox;
    protected CenterTitledPane titledPane;
    protected String topDescriptionText;
    protected List<PartData> partDataList;
    protected String type;
    protected RightController rightController;
    public CardPane(String type){
        this.type = type;
        this.buttonHBox = new ButtonHBox();
        /* Om toegang te krijgen tot SidePaneController*/
        this.rightController = rightSidePane.getRightController();
        BorderPane.setMargin(this, new Insets(15));
        BorderPane.setAlignment(buttonHBox, Pos.BOTTOM_RIGHT);
    }

    public void fill(){
    }

    public RightController getRightController() {
        return rightController;
    }

    public void setRightSidePane(RightSidePane rightSidePane, List<PartData> partDataList){
        this.rightSidePane = rightSidePane;
        this.partDataList = partDataList;
        rightSidePane.changeBottomChild(null);
        getChildren().remove(titledPane);
        fill();
    }

    public void addBottomButtons(){
        if(rightSidePane != null){
            rightSidePane.changeBottomChild(buttonHBox);
        }
    }

    public final void createTitledPane(){
        titledPane = new CenterTitledPane();
        getChildren().add(titledPane);
        createPartsFiller();
    }

    public void createPartsFiller(){
        new TitledPaneFiller(titledPane, partDataList, type).fillParts();
    }

    public void setCorrectTextField(String correctString){
    }
}