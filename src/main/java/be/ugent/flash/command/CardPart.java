package be.ugent.flash.command;

/**
 * Voor mr, mcc en mcs
 */
public class CardPart extends PartData {

    private byte[] part; /* TODO: aanpassen naar String*/
    public CardPart(int question_id, int part_id, byte[] part){
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
