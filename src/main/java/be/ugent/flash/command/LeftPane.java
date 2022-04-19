package be.ugent.flash.command;

import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.util.Objects;

/**
 * linkerkant van de beheersinterface
 */
public class LeftPane extends GridPane {

    private final QuestionTableView tableView;
    public LeftPane(){
        setMaxHeight(715);
        this.tableView = new QuestionTableView();
        HBox hBox = new HBox();
        hBox.setMaxWidth(500);
        hBox.getChildren().addAll(new Button("Vraag toevoegen"), new Button("Vraag verwijderen"));
        hBox.setAlignment(Pos.CENTER_RIGHT);
        for(Node child: hBox.getChildren()){
            child.setStyle("-fx-font-size: 12px");

        }
        setMargin(hBox, new Insets(0, 10, 0, 0));
        setMargin(tableView, new Insets(0, 0, 0, 5));
        getRowConstraints().add(new RowConstraints(tableView.getMaxHeight()));
        GridPane.setConstraints(tableView, 0, 0);
        GridPane.setConstraints(hBox, 0, 1);
        getColumnConstraints().add(new ColumnConstraints(500));
        getChildren().addAll(tableView, hBox);
        setVgap(10);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public QuestionTableView getTableView(){
        return tableView;
    }
}