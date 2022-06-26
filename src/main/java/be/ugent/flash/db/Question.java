package be.ugent.flash.db;

public record Question(int id, String title, String text, byte[] middleImage, String questionType, String correctAnswer) {
}
