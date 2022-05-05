package be.ugent.flash.command;

import javafx.stage.FileChooser;

import java.io.File;
import java.sql.*;

public class DatabaseMaker extends FileDataCollector {

    public DatabaseMaker(MainBorderPane startWindow){
        super(startWindow);
    }
    public void createFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Text Files", "*.sqlite"
        ));
        File databaseFile = fileChooser.showSaveDialog(stage);
        if(databaseFile != null && databaseFile.getName().endsWith(".sqlite")){
            addTables(databaseFile.getPath());
        }
    }

    public void addTables(String database){
        try {
            getFileData(database);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}