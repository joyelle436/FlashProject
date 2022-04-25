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

    public byte[] getPart() {
        return part;
    }
    /*
    Bron: https://stackoverflow.com/questions/38095984/convert-javafx-image-object-to-byte-array
     */
    public void setPart(Image imagePart) {
        int w = (int) imagePart.getWidth();
        int h = (int) imagePart.getHeight();

        byte[] bytePart = new byte[w*h*4];
        imagePart.getPixelReader()
                .getPixels(0, 0, w, h, PixelFormat.getByteBgraInstance(), bytePart, 0, w*4);
        part = bytePart;
        setImagePart();
    }

    public Image getImagePart() {
        return imagePart;
    }

    private void setImagePart(){
        imagePart = new Image(new ByteArrayInputStream(part));
    }
}
