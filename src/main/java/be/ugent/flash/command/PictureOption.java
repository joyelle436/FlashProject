package be.ugent.flash.command;

import be.ugent.flash.command.rights.TopGridpane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Staat in {@link be.ugent.flash.command.rights.TopGridpane}
 */
public class PictureOption extends GridPane {
    private final TopGridpane topGridpane;
    private final ImageArea imageArea;
    private final AddPictureButton addPicture;
    private final HBox hBox;
    public PictureOption(TopGridpane topGridpane) {
        this.topGridpane = topGridpane;
        this.imageArea = new ImageArea();
        this.addPicture = new AddPictureButton();
        ChangePictureButton changePicture = new ChangePictureButton();
        DeletePictureButton deletePicture = new DeletePictureButton();
        this.hBox = new HBox();
        hBox.getChildren().addAll(changePicture, deletePicture);
        hBox.setSpacing(10);
        setVgap(5);
        GridPane.setConstraints(hBox, 0, 1);
    }

    /**
     * Wordt opgeroepen in {@link be.ugent.flash.command.rights.buttons.Save}
     */

    public Image getImage() {
        return imageArea.getImage();
    }

    public void addImageToImageView(Image newImage){
        imageArea.addImage(newImage);
        getChildren().addAll(imageArea, hBox);
    }

    public void addButtons(){
        getChildren().clear();
        getChildren().addAll(imageArea, hBox);
    }

    public void addButton(){
        imageArea.setImage(null);
        getChildren().clear();
        getChildren().add(addPicture);
    }

    private static class ImageArea extends ImageView {
        public ImageArea(){
            setImage(null);
        }
        public void addImage(Image newImage){
            setFitWidth(250);
            setFitHeight(115);
            setPreserveRatio(true);
            setImage(newImage);
        }
    }

    private class AddPictureButton extends Button implements EventHandler<ActionEvent> {
        public AddPictureButton(){
            super("Voef afbeelding toe");
            GridPane.setConstraints(this, 0, 0);
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                    "Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"
            ));
            File databaseFile = fileChooser.showOpenDialog(topGridpane.getRightController().getMainController().getMainStage());
            if(databaseFile != null){
                imageArea.addImage(new Image(databaseFile.getPath()));
                addButtons();
            }
        }
    }

    private class ChangePictureButton extends Button implements EventHandler<ActionEvent> {
        public ChangePictureButton(){
            super("Wijzig...");
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                    "Image Files", "*.png", "*.jpeg", "*.jpg", "*.gif", "*.bmp"
            ));
            File databaseFile = fileChooser.showOpenDialog(topGridpane.getRightController().getMainController().getMainStage());
            if(databaseFile != null){
                imageArea.addImage(new Image(databaseFile.getPath()));
            }
        }
    }

    private class DeletePictureButton extends Button implements EventHandler<ActionEvent> {
        public DeletePictureButton(){
            super("Verwijder");
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent){
            getChildren().clear();
            addButton();
        }
    }
}