package be.ugent.flash;

import be.ugent.flash.command.PartData;
import be.ugent.flash.data.Question;
import be.ugent.flash.panels.*;

import java.util.*;

public class CommandMapMaker {

    private Map<String, String> qTypeMap; /* voor de beheersinterface */
    private Map<Integer, String> idTypeMap; /* voor de beheersinterface */
    private final Map<Integer, List<PartData>> partsDataMap;
    private Map<String, QuestionPane> questionPaneMap;

    public CommandMapMaker(){
        this.partsDataMap = new HashMap<>();
    }

    public void makePartDataMap(List<PartData> list){
        for(PartData partData: list){
            if(!partsDataMap.containsKey(partData.getQuestion_id())){
                partsDataMap.put(partData.getQuestion_id(), new ArrayList<>());
            }
            partsDataMap.get(partData.getQuestion_id()).add(partData);
        }
    }

    public void makeTypeMap(){
        this.qTypeMap = Map.of(
                "mcs", "Meerkeuze (standaard)",
                "mcc", "Meerkeuze (compact)",
                "mci", "Meerkeuze (afbeeldingen)",
                "mr", "Meerantwoord",
                "open", "Open (tekst)",
                "openi", "Open (geheel)"
        );
    }

    public void makeIdMap(List<Question> questionList){
        idTypeMap = new HashMap<>();
        for(Question question: questionList){
            idTypeMap.put(question.id(), question.questionType());
        }
    }

    public void makePanesMap(){
        this.questionPaneMap = Map.of(
                "mcs", new StandaardQuestionPane(),
                "mcc", new CompactQuestionPane(),
                "mci", new PictureQuestionPane(),
                "mr", new MultipleQuestionPane(),
                "open", new OpenQuestionPane(),
                "openi", new OpenQuestionPane()
        );
    }

    public String getIdType(int id){
        return idTypeMap.get(id);
    }
    public String getStringType(String key){
        return qTypeMap.get(key);
    }
    public List<PartData> getPartData(int key){
        return partsDataMap.get(key);
    }
    public QuestionPane getQuestionPane(String key){
        return questionPaneMap.get(key);
    }
}