package be.ugent.flash.command;

import java.sql.SQLException;
import java.util.*;

/**
 * Start linkerkant en vervolgens rechterkant aan
 */
public class PaneStarter {
    public PaneStarter(MainBorderPane startWindow, Map<Integer, String[]> questionMap, String database) throws SQLException {
        new SidePaneConnection(startWindow, questionMap, database).showPanes();
    }
}