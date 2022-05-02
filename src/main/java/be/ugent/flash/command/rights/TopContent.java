package be.ugent.flash.command.rights;

import be.ugent.flash.command.NodeTable;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/**
 * Gegevens van de {@link TopGridpane}
 */
public class TopContent {

    /*
    Staan bovenaan aan de rechterkant
    */
    private final Label[] toplabels;
    private final NodeTable nodeTable;
    public TopContent(TopGridpane topGridpane){
        this.nodeTable = new NodeTable(topGridpane);
        this.toplabels = new Label[]{
                new Label("Titel"),/* -> Textfield */
                new Label("Type"),/* -> Label */
                new Label("Tekst"),/* -> TextField */
                new Label("Afbeelding")
        };
    }
    /*
    Wordt in TopGridpane opgeroepen
     */
    public void addContent(){
        nodeTable.placeContent();
        for(int index = 0; index < 4; index++){
            GridPane.setConstraints(toplabels[index], 0, index);
            GridPane.setValignment(toplabels[index], VPos.TOP);
            toplabels[index].setStyle("-fx-font-size: 13px");
        }
    }

    public Label[] getToplabels() {
        return toplabels;
    }

    public Node[] getNodeTable() {
        return nodeTable.getTable();
    }

    public void setQuestionTopContent(String title, String type, String text, byte[] mainImage){
        nodeTable.fillContent(title, type, text, mainImage);
    }

    public String[] getQuestionTopContent(){
        return nodeTable.getContent();
    }

    public Image getMiddleImage(){
        return nodeTable.getMainImage();
    }

    public void addListenerToTextField(){
        nodeTable.addTextListener();
    }
}