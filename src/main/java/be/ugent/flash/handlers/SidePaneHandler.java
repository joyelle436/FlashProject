package be.ugent.flash.handlers;

import be.ugent.flash.command.QuestionData;

import java.util.List;

public class SidePaneHandler {

    public SidePaneHandler(){
    }

    /*
    Methodes die normaal gezien in SidePaneController zouden zijn
     */
    public QuestionData getQToShow(List<QuestionData> questionDataList, String title){
        QuestionData questionData = questionDataList.get(0);
        int index = 1;
        while(index < questionDataList.size() &&
                !questionData.getTitle().equals(title)){
            questionData = questionDataList.get(index);
            index += 1;
        }
        return questionData;
    }
}
