package be.ugent.flash;

/**
 * Houd een rij bij van de tabel question
 */
public record QuestionRow(int id, String title, String text, byte[] middleImage, String questionType, String correctAnswer) {
}
