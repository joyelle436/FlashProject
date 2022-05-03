package be.ugent.flash.command;


import be.ugent.flash.command.rights.TopGridpane;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * Bevat nodes die in {@link be.ugent.flash.command.rights.TopGridpane} staan
 */
public class NodeTable implements TextInputListener {

    private final TextField titleField;
    private final TextArea textArea;
    private final Label typeLabel;
    private final PictureOption pictureOption;
    private final Node[] table;
    private final TopGridpane topGridpane;
    public NodeTable(TopGridpane topGridpane){
        this.topGridpane = topGridpane;
        this.titleField = new TextField();
        this.textArea = new TextArea();
        this.typeLabel = new Label("");
        textArea.setPrefSize(575, 100);
        textArea.setWrapText(true);
        this.pictureOption = new PictureOption(topGridpane);
        this.table = new Node[]{
                titleField,
                typeLabel,
                textArea,
                pictureOption
        };
    }

    public Node[] getTable() {
        return table;
    }

    public void placeContent(){
        for(int index = 0; index < 4; index++){
            GridPane.setConstraints(table[index], 1, index);
            table[index].setStyle("-fx-font-size: 13px");
        }
    }

    public void fillContent(String title, String type, String text, byte[] mainImage){
        titleField.setText(title);
        typeLabel.setText(type);
        textArea.setText(text);
        if(mainImage != null){
            pictureOption.addImageToImageView(new Image(new ByteArrayInputStream(mainImage)));
        } else {
            pictureOption.addSingleButton();
        }
        addTextListener();
    }

    public String[] getContent(){
        return new String[]{titleField.getText(), textArea.getText()};
    }

    public byte[] getMainImage(){
        return pictureOption.getImage();
    }

    @Override
    public void addTextListener() {
        for (Node node : getTable()) {
            if(node instanceof TextInputControl){
                ((TextInputControl) node).textProperty().addListener((observable, oldtext, newtext) -> {
                    topGridpane.getRightController().getMainController().disableTableView();
                });
            }
        }
    }
}