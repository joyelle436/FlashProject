package be.ugent.flash.command;

import javafx.scene.image.Image;

/**
 * Voor mci
 */
public class PictureCardPart extends PartData {

    private byte[] part; /* TODO: aanpassen naar Image*/
    public PictureCardPart(int question_id, int part_id, byte[] part){
        super(question_id, part_id);
        this.part = part;
    }


    public byte[] getPart() {
        return part;
    }

    public void setPart(byte[] part) {
        this.part = part;
    }
}
