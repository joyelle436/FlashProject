package be.ugent.flash.cardspanes;

import be.ugent.flash.command.*;
import be.ugent.flash.command.rights.ButtonHBox;
import be.ugent.flash.command.rights.RightSidePane;
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
    public CardPane(String type){
        this.type = type;
        this.buttonHBox = new ButtonHBox();
        BorderPane.setMargin(this, new Insets(15));
        BorderPane.setAlignment(buttonHBox, Pos.BOTTOM_RIGHT);
    }

    public void fill(){
    }

    public void setRightSidePane(RightSidePane rightSidePane, List<PartData> partDataList){
        this.rightSidePane = rightSidePane;
        this.partDataList = partDataList;
        rightSidePane.changeBottomChild(null);
        getChildren().remove(titledPane);
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