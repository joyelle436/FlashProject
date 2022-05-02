package be.ugent.flash.command;

import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.*;

/**
 * Start linkerkant en vervolgens rechterkant aan
 */
public class PaneStarter {
    public PaneStarter(MainBorderPane startWindow, Map<Integer, String[]> questionMap, String database, Stage stage) throws SQLException {
        new SidePaneConnection(startWindow, questionMap, database, stage).showPanes();
    }
}