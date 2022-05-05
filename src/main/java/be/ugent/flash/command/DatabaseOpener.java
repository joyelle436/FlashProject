package be.ugent.flash.command;

import be.ugent.flash.viewer.ErrorDisplay;
import javafx.stage.*;

import java.io.File;

public class DatabaseOpener extends FileDataCollector {


    public DatabaseOpener(MainBorderPane startWindow){
        super(startWindow);
    }
    public void getFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Text Files", "*.sqlite"
        ));
        File databaseFile = fileChooser.showOpenDialog(stage);
        if(databaseFile != null){
            try {
                getFileData(databaseFile.getPath());
            } catch (Exception e) {
                ErrorDisplay.showAlert("Fout bij het nemen van gegevens uit de databank");
            }
        }
    }
}