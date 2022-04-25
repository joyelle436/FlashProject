package be.ugent.flash.command;

import javafx.scene.control.Button;

/**
 * Voor de beheersinterface
 */
public class PartData {

    private int question_id;
    private int part_id;
    public PartData(int question_id, int part_id) {
        this.question_id = question_id;
        this.part_id = part_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public int getPart_id() {
        return part_id;
    }

    public byte[] getPart() {
        return null;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }
}
