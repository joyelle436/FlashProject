package be.ugent.flash.command.rights.buttons;

import be.ugent.flash.ViewerMapMaker;
import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.command.DatabaseCollector;
import be.ugent.flash.viewer.ErrorDisplay;
import be.ugent.flash.viewer.cards.Type;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.SQLException;
import java.util.Objects;

public class Preview extends BottomButton {
    private final ViewerMapMaker mapMaker = new ViewerMapMaker();
    private DatabaseCollector databaseConnector;
    public Preview(CardPane cardPane) {
        super(cardPane);
        this.databaseConnector = null;
        this.mapMaker.makeFactoryMap();
        this.mapMaker.makeVisitorMap();
        setText("Preview");
        QuestionPreview questionPreview = null;
        try {
            questionPreview = new QuestionPreview();
        } catch (SQLException e) {
            new ErrorDisplay().showAlert(e.getMessage());
        }
        QuestionPreview finalQuestionPreview = questionPreview;
        setOnMousePressed(mouseEvent -> {
            Objects.requireNonNull(finalQuestionPreview).show();
            System.out.println("pressed");
        });

        setOnMouseReleased(mouseEvent -> {
            System.out.println("released");
            Objects.requireNonNull(finalQuestionPreview).close();
        });
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
    }

    private class QuestionPreview extends Stage {
        public QuestionPreview() throws SQLException {
            if(cardPane != null){
                if(databaseConnector == null){
                    databaseConnector = new DatabaseCollector(cardPane.getRightSidePane().getRightController().getDatabase());
                }
                Type type = mapMaker.getFactory(cardPane.getQuestion().questionType()).makeCard(this, cardPane.getQuestion());
                if(!(cardPane.getQuestion().questionType().equals("open") || cardPane.getQuestion().questionType().equals("openi"))){
                    type.setAnswers(databaseConnector.getPartsContent(cardPane.getQuestion().id()));
                }
                //noinspection unchecked
                mapMaker.getVisitor(cardPane.getQuestion().questionType()).buildCard(type);
                setScene(new Scene(type, Color.TRANSPARENT));
                setResizable(false);
                initStyle(StageStyle.TRANSPARENT);
                centerOnScreen();
            }
        }
    }
}
