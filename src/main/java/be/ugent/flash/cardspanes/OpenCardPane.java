package be.ugent.flash.cardspanes;

import be.ugent.flash.command.ImageByteConverter;
import be.ugent.flash.command.TextInputListener;
import be.ugent.flash.command.rights.RightSidePane;
import be.ugent.flash.data.Question;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

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
        correctTextField.setText(question.correctAnswer());
        addTextListener();
    }

    /**
     * Geeft false terug als er een fout staat in de beheersinterface
     */
    public boolean updateQuestion() throws SQLException {
        return super.updateQuestion();
    }

    @Override
    public void addTextListener() {
        correctTextField.textProperty().addListener((observable, oldtext, newtext) -> {
            /**
             * TODO: Verbeteren(te vroeg)
             */
            getRightSidePane().getRightController().getMainController().disableTableView();
            correct = correctTextField.getText();
        });
    }
}