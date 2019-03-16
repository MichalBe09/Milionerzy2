package com.company;

import java.util.HashMap;
import java.util.Map;

public class QuestionsDB {

    Map<String, String > questionsDb = new HashMap<>();

    public QuestionsDB(){
        addStartDataBase();
    }

    private void addStartDataBase(){
        questionsDb.put("Jaka część mowy odpowiada na pytania: kto, co?", "Rzeczownik");
        questionsDb.put("Co powstanie z wody, gdy ją zamrozimy?", "Lód");
        questionsDb.put("Kogo uratowała Calineczka?", "Jaskółkę");
        questionsDb.put("Jaka legenda jest związana z Warszawą?", "O syrence");
        questionsDb.put("Kto ma łeb obdarty?", "Ten kto gra w karty");
        questionsDb.put("Co nie jest nazwą stylu pływackiego?", "Rekin");
        questionsDb.put("Która z tych małp jest największa?", "Goryl");
        questionsDb.put("W jakim mieście jest Wawel?", "W Krakowie");
        questionsDb.put("Ile jest znaków zodiaku?", "12");
        questionsDb.put("Do ilu punktów liczy się set w tenisie stołowym?", "21");
        questionsDb.put("Jakie są najwyższe góry na świecie?", "Himalaje");
        questionsDb.put("Gdzie leży Arktyka?", "Wokół bieguna północnego");
        questionsDb.put("Jaki gaz o właściwościach wybuchowych wydziela się podczas ładowania akumulatorów kwasowych?", "Wodór");
        questionsDb.put("Wstrząs jest to:","Stan niedotlenienia mózgu");
        questionsDb.put("Gaz propan-butan jest:", "Cięższy od powietrza");
        questionsDb.put("Hg to symbol:", "Rtęci");
        questionsDb.put("Jak reagują ze sobą ładunki różnoimienne?", "Przyciągają się");
        questionsDb.put("Jaki jest polski odpowiednik angielskiego imienia George?", "Jerzy");
        questionsDb.put("Który z francuskich królów posiadał przydomek - Król Słońce?", "Ludwik XIV");
    }

    public Map<String, String> getQuestionsDb() {
        return questionsDb;
    }

    public void setQuestionsDb(Map<String, String> questionsDb) {
        this.questionsDb = questionsDb;
    }

    public void addQuestionToDb(String key, String value){
        this.questionsDb.put(key, value);
    }
    //ta metoda nie jest konieczna ale czasem może uprościć
    public String getQuestionFromDb(String key){
        return questionsDb.get(key);
    }
}
