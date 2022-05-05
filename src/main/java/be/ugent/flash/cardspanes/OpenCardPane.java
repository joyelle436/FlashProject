package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RedPopUp;
import be.ugent.flash.command.right.TextInputListener;
import be.ugent.flash.command.right.RightSidePane;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.sql.SQLException;

/**
 * open en openi
 */
public class OpenCardPane extends CardPane implements TextInputListener {

    private final TextField correctTextField;
    public OpenCardPane(String type){
        super(type);
        Label label = new Label("Correct Antwoord");
        HBox hbox = new HBox();
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
        fillCardPane();
    }

    public void fillCardPane(){
        super.fillCardPane();
        correctTextField.setText(question.correctAnswer());
        addTextListener();
    }

    /**
     * Geeft false terug als er een fout staat in de beheersinterface
     */
    public boolean updateQuestion() throws SQLException {
        if(type.equals("openi")){
            try {
                Integer.parseInt(correct);
            } catch (NumberFormatException e){
                new RedPopUp("Het antwoord moet een geheel getal zijn");
                return false;
            }
        }
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