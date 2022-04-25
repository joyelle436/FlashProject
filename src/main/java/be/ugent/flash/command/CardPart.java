package be.ugent.flash.command;

import java.nio.charset.StandardCharsets;

/**
 * Voor mr, mcc en mcs
 */
public class CardPart extends PartData {

    private byte[] part; /* wordt naar String aangepast in textfield */
    public CardPart(int question_id, int part_id, byte[] part){
        super(question_id, part_id);
        this.part = part;
    }

    public byte[] getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part.getBytes(StandardCharsets.UTF_8);
    }
}
