package be.ugent.flash.command;

import be.ugent.flash.cardspanes.*;

import java.util.*;
import java.util.stream.Collectors;

public class CommandMapMaker {

    private Map<String, String> qTypeMap; /* voor de beheersinterface */
    private Map<String, CardPane> questionPaneMap;
    private Map<String, String> swapedQTypeMap;

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

    public void makeswapedQTypeMap(){
        makeTypeMap();
        /*
          Bron: {@link https://stackoverflow.com/questions/38589875/swap-keys-with-values-and-vice-versa-of-hashmap}
         */
        this.swapedQTypeMap = qTypeMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    public void makePanesMap(){
        this.questionPaneMap = Map.of(
                "mcs", new SingleAnswerCardPane("mcs"),
                "mcc", new SingleAnswerCardPane("mcc"),
                "mci", new SingleAnswerCardPane("mci"),
                "mr", new MultipleAnswerCardPane("mr"),
                "open", new OpenCardPane("open"),
                "openi", new OpenCardPane("openi")
        );
    }

    public String getStringType(String key){
        return qTypeMap.get(key);
    }
    public CardPane getQuestionPane(String key){
        return questionPaneMap.get(key);
    }
    public String getSwapedStringType(String key){
        return swapedQTypeMap.get(key);
    }
}