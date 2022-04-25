package be.ugent.flash.command;

import java.util.List;

/**
 *
 */
public class QuestionModifier {

    private final List<QuestionData> questionDataList;
    private final List<PartData> partDataList;

    public QuestionModifier(List<QuestionData> questionDataList, List<PartData> partDataList){
        this.questionDataList = questionDataList;
        this.partDataList = partDataList;
    }

    public List<QuestionData> getQuestionDataList() {
        return questionDataList;
    }

    public List<PartData> getPartDataList() {
        return partDataList;
    }

    public void addQuestionData(QuestionData questionData){
        questionDataList.add(questionData);
    }
    public void addPartData(PartData partData){
        partDataList.add(partData);
    }

    public void removeQuestionData(QuestionData questionData){
        questionDataList.remove(questionData);
    }
    public void aremovePartData(PartData partData){
        partDataList.remove(partData);
    }
}
