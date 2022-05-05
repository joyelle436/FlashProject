package be.ugent.flash.command.right;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.ImageByteConverter;
import be.ugent.flash.data.Part;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * Voor mci
 */
public class AnswerChoiceImage extends AnswerChoiceObject implements EventHandler<MouseEvent> {
    private final ImageView middleImageView;
    private final BorderPane borderPane;
    private byte[] newImagePart;
    public AnswerChoiceImage(TitledPaneGridpane gridpane){
        super(gridpane);
        this.newImagePart = null; // imagePath is null als de afbeelding niet veranderd werd
        setMargin(checkBox, new Insets(28, 0, 0, 0));
        this.middleImageView = new ImageView();
        middleImageView.setFitWidth(100);
        middleImageView.setFitHeight(100);
        middleImageView.setPreserveRatio(true);
        this.borderPane = new BorderPane();
        borderPane.setPrefWidth(100);
        borderPane.setPrefHeight(100);
        borderPane.setOnMouseClicked(this);
        borderPane.setCenter(new Label("(leeg)"));
        setMargin(removeButton, new Insets(25, 0, 0, 0));
        getChildren().addAll(checkBox, borderPane, removeButton);
        GridPane.setMargin(this, new Insets(0, 0, 0, 15));
    }

    public byte[] getImagePath() {
        return newImagePart;
    }

    public void setNewImagePart(byte[] newImagePart) {
        this.newImagePart = newImagePart;
    }

    public void setAnswerImage(Image image){
        middleImageView.setImage(image);
        borderPane.setCenter(middleImageView);
    }

    public void putInGridpane(Part part, int position) {
        if(part != null && part.part() != null){
            Image image = new Image(new ByteArrayInputStream(part.part()));
            setAnswerImage(image);
        }
        super.putInGridpane(part, position);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                    "Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"
            ));
            File imageFile = fileChooser.showOpenDialog(gridpane.getRightController().getMainController().getMainStage());
            if(imageFile != null){
                setAnswerImage(new Image(imageFile.getPath()));
                newImagePart = ImageByteConverter.fileToByte(imageFile);
            }
        }
    }
}