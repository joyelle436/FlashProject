package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

public class OpenQuestion extends Type {
    protected TextField answerField;
    protected Label foutlabel;
    protected OpenQuestion(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        super(stage, row, answers);
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(25));
        GridPane gridPane = new GridPane();
        this.answerField = new TextField();
        answerField.setId("textfield");
        answerField.setFont(new Font(20));
        foutlabel = new Label();
        foutlabel.setVisible(false);
        foutlabel.setFont(new Font(17.5));
        GridPane.setConstraints(answerField, 0, 0);
        GridPane.setConstraints(foutlabel, 0, 1);
        gridPane.getColumnConstraints().add(new ColumnConstraints(400));
        answerField.setMaxWidth(400);
        gridPane.getChildren().addAll(answerField, foutlabel);
        if(row.get(3) != null){
            setBottom(gridPane);
            setMargin(gridPane, new Insets(0, 15, 100, 20));
        } else {
            setCenter(gridPane);
            setMargin(gridPane, new Insets(20, 0, 0, -15));
        }
    }
}