package be.ugent.flash.command.right;

import be.ugent.flash.command.ImageByteConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Staat in {@link be.ugent.flash.command.right.TopGridpane}
 */
public class PictureOption extends GridPane {
    private final TopGridpane topGridpane;
    private final ImageArea imageArea;
    private final AddPictureButton addPicture;
    private final HBox hBox;
    private File mainImageFile;
    public PictureOption(TopGridpane topGridpane) {
        this.topGridpane = topGridpane;
        this.imageArea = new ImageArea();
        this.addPicture = new AddPictureButton();
        this.mainImageFile = new File("");
        ChangePictureButton changePicture = new ChangePictureButton();
        DeletePictureButton deletePicture = new DeletePictureButton();
        this.hBox = new HBox();
        hBox.getChildren().addAll(changePicture, deletePicture);
        hBox.setSpacing(10);
        setVgap(5);
        GridPane.setConstraints(hBox, 0, 1);
    }

    /**
     * Wordt opgeroepen in {@link be.ugent.flash.command.right.buttons.Save}
     */

    public byte[] getImage() {
        if(mainImageFile == null){
            return null;
        } else if(mainImageFile.getPath().equals("")){
            return new byte[0];
        }
        return ImageByteConverter.fileToByte(mainImageFile);
    }

    public void addImageToImageView(Image newImage){
        imageArea.addImage(newImage);
        addButtons();
    }

    public void addButtons(){
        getChildren().clear();
        getChildren().addAll(imageArea, hBox);
    }

    public void addSingleButton(){
        getChildren().clear();
        getChildren().add(addPicture);
    }

    public void openFileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"
        ));
        File imageFile = fileChooser.showOpenDialog(topGridpane.getRightController().getMainController().getMainStage());
        if(imageFile != null){
            addImageToImageView(new Image(imageFile.getAbsolutePath()));
            mainImageFile = imageFile;
        }
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
            super("Voeg afbeelding toe...");
            GridPane.setConstraints(this, 0, 0);
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            openFileChooser();
        }
    }

    private class ChangePictureButton extends Button implements EventHandler<ActionEvent> {
        public ChangePictureButton(){
            super("Wijzig...");
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            openFileChooser();
        }
    }

    private class DeletePictureButton extends Button implements EventHandler<ActionEvent> {
        public DeletePictureButton(){
            super("Verwijder");
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent){
            mainImageFile = null;
            addSingleButton();
        }
    }
}