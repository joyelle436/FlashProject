package be.ugent.flash.command;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;

import java.io.ByteArrayInputStream;


/**
 * Voor mci
 */
public class PictureCardPart extends PartData {

    private byte[] part; /* wordt naar Image aangepast bij het aantonen v/de button */
    private Image imagePart;
    public PictureCardPart(int question_id, int part_id, byte[] part){
        super(question_id, part_id);
        this.part = part;
        this.imagePart = new Image(new ByteArrayInputStream(part));
    }

    /**
     * Voor de viewer
     */
    public byte[] getPart() {
        return part;
    }

    public void setPart(Image imagePart) {
        part = ImageByteConverter.imageToByte(imagePart);
        setImagePart();
    }

    /**
     * Voor de beheersinterface
     */
    public Image getImagePart(){
        return imagePart;
    }

    private void setImagePart(){
        imagePart = new Image(new ByteArrayInputStream(part));
    }
}
