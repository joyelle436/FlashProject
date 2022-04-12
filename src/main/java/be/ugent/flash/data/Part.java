package be.ugent.flash.data;

public record Part(int question_id, int part_id, byte[] part) {
    /*
     * De kolom <<part>> sla ik als <<byte[]>> op omdat er bij een mci het een afbeelding is.
     * Dus die bepaalde klasse gaat dat zelf omzetten naar een string/afbeelding
     */
}
