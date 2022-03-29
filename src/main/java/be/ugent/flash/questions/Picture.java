package be.ugent.flash.questions;

import javafx.stage.Stage;

import java.util.List;

/**
 * mci
 */
public class Picture extends Type {
    protected Picture(Stage stage, String DATA, String[] row, List<String[]> answers, byte[] aByte) {
        super(stage, DATA, row, answers, aByte);
    }

    @Override
    public void build() {
        super.build();
    }

}
