package be.ugent.flash.visitors;

import be.ugent.flash.questions.OpenQuestion;

public class OpenQuestionVisitor implements CardVisitor<OpenQuestion>{

    public static void buildCard(OpenQuestion openQuestion){
        openQuestion.accept(new OpenQuestionVisitor());
    }
    @Override
    public void visit(OpenQuestion type) {

    }
}
