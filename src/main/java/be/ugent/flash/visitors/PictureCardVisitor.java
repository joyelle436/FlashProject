package be.ugent.flash.visitors;

import be.ugent.flash.questions.PictureCard;

public class PictureCardVisitor implements CardVisitor<PictureCard>{

    public static void buildCard(PictureCard pictureCard){
        pictureCard.accept(new PictureCardVisitor());
    }
    @Override
    public void visit(PictureCard type) {

    }
}
