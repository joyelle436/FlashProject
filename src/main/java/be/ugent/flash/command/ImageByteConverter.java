package be.ugent.flash.command;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;

import java.io.File;
import java.nio.file.Files;

/**
 * Gebruik door {@link be.ugent.flash.cardspanes.OpenCardPane} en {@link PictureCardPart}
 */
public class ImageByteConverter {

    /*
    Bron: https://stackoverflow.com/questions/38095984/convert-javafx-image-object-to-byte-array
     */
    public static byte[] imageToByte(Image middleImage){
        byte[] byteImage;
        try {
            int w = (int) middleImage.getWidth();
            int h = (int) middleImage.getHeight();
            byteImage = new byte[w*h*4];
            middleImage.getPixelReader()
                    .getPixels(0, 0, w, h, PixelFormat.getByteBgraInstance(), byteImage, 0, w*4);
        } catch (Exception e){
            return null;
        }
        System.out.println("byte gelukt");
        return byteImage;
    }

    /*
    Bron: https://stackoverflow.com/questions/3211156/how-to-convert-image-to-byte-array-in-java
     */
    public static byte[] fileToByte(File mainImageFile){
        try {
            return Files.readAllBytes(mainImageFile.toPath());
        } catch (Exception e) {
            return null;
        }
    }
}
