package be.ugent.flash.questions;

import javafx.stage.Stage;

import java.util.List;

/**
 * mci
 */
public class Picture extends Type {
    protected Picture(Stage stage, String DATA, String[] row, List<String[]> answers) {
        super(stage, DATA, row, answers);
    }

    @Override
    public void build() {
        super.build();
    }

    @Override
    public void addImage() {

    }
}
