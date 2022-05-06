package be.ugent.flash.command;

import java.io.File;
import java.nio.file.Files;

/**
 * Gebruik door {@link be.ugent.flash.cardspanes.OpenCardPane}
 */
public class ImageByteConverter {
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