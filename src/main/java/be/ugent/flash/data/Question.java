package be.ugent.flash.data;

public record Question(int id, String title, String text, byte[] middleImage, String questionType, String correctAnswer) {
}
