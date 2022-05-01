package be.ugent.flash.cardspanes;

import be.ugent.flash.command.TextInputListener;
import be.ugent.flash.command.rights.RightSidePane;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * open en openi
 */
public class OpenCardPane extends CardPane implements TextInputListener {

    private final Label label;
    private final HBox hbox;
    private final TextField correctTextField;
    public OpenCardPane(String type){
        super(type);
        this.label = new Label("Correct Antwoord");
        this.hbox = new HBox();
        hbox.setMaxHeight(50);
        hbox.setAlignment(Pos.CENTER_LEFT);
        label.setFont(new Font(13));
        correctTextField = new TextField();
        correctTextField.setFont(new Font(13));
        correctTextField.setPrefWidth(200);
        hbox.getChildren().addAll(label, correctTextField);
        HBox.setMargin(label, new Insets(0, 5, 0, 0));
        getChildren().add(hbox);
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        super.setRightSidePane(rightSidePane);
        fill();
    }

    public void fill(){
        super.fill();
        addBottomButtons();
    }

    public void setCorrectTextField(String correctString){
        correctTextField.setText(correctString);
        addTextListener();
    }

    @Override
    public void addTextListener() {
        correctTextField.textProperty().addListener((observable, oldtext, newtext) -> {
           if(!oldtext.equals("") && !newtext.equals("")){
               getRightSidePane().getRightController().getMainController().disableTableView();
           }
        });
    }
}