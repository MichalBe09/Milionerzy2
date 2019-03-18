package com.company.baza_pytań;

import com.company.konstruktory.Answers;
import com.company.konstruktory.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionsDB {

     Map<Integer, Question> questionsDb = new HashMap<>();

    public QuestionsDB(){
        addStartDataBase();
    }

    public Map<Integer, Question> getQuestionsDb() {
        return questionsDb;
    }

    public void setQuestionsDb(Map<Integer, Question> questionsDb) {
        this.questionsDb = questionsDb;
    }

    public   void addStartDataBase() { // tu znajdują się wszystkie pytania z propozycjami odpowiedzi, wciąż w budowie

        questionsDb.put(0, new Question("Jaka część mowy odpowiada na pytania: kto, co?", "Rzeczownik", new Answers("Czasownik", "Pyzymiotnik", "Przyimek")));
        questionsDb.put(1, new Question("Co powstanie z wody, gdy ją zamrozimy?", "Lód", new Answers("Para", "Kryształy", "Żywica")));
        questionsDb.put(2, new Question("Kogo uratowała Calineczka?", "Jaskółkę", new Answers("Zółwia", "Bobra", "Łosia")));
        questionsDb.put(3, new Question("Jaka legenda jest związana z Warszawą?", "O syrence", new Answers("O szakalu", "O rycerzu", "O orlim gnieździe")));
        questionsDb.put(4, new Question("Kto ma łeb obdarty?", "Ten kto gra w karty", new Answers("Ten kto robi żarty", "Ten kto sprzedaje karty", "Ten kto jest nienażarty")));
        questionsDb.put(5, new Question("Co nie jest nazwą stylu pływackiego?", "Rekin", new Answers("Żabka", "Piesek", "Motylek")));
        questionsDb.put(6, new Question("Która z tych małp jest największa?", "Goryl", new Answers("Orangutan", "Pawian", "Makak czubaty")));
        questionsDb.put(7, new Question("W jakim mieście jest Wawel?", "W Krakowie", new Answers("W Katowicach","W Częstochowie","W Szczecinie")));
        questionsDb.put(8, new Question("Ile jest znaków zodiaku?", "12", new Answers("21", "14", "15")));
        questionsDb.put(9, new Question("Do ilu punktów liczy się set w tenisie stołowym?", "21", new Answers("22", "24", "15")));
        questionsDb.put(10, new Question("Jakie są najwyższe góry na świecie?", "Himalaje", new Answers("Alpy", "Tatry", "Andy")));
        questionsDb.put(11, new Question("Gdzie leży Arktyka?", "Wokół bieguna północnego", new Answers("Wokół bieguna południowego", "Na Grenlandii", "Na Cyprze")));
        questionsDb.put(12, new Question("Jaki gaz o właściwościach wybuchowych wydziela się podczas ładowania akumulatorów kwasowych?", "Wodór", new Answers("Hel","Acetylen", "Tlen")));
        questionsDb.put(13, new Question("Wstrząs jest to:","Stan niedotlenienia mózgu", new Answers("Uraz mechaniczny", "Zatrzymanie układu oddechowego","Krwawienie z uszu")));
        questionsDb.put(14, new Question("Gaz propan-butan jest:", "Cięższy od powietrza", new Answers("Lżejszy od powietrza","O wadze powietrza","Nie istniejee połączenie tych gazów")));
        questionsDb.put(15, new Question("Hg to symbol:", "Rtęci", new Answers("Żelaza", "Manganu", "Glinu")));
        questionsDb.put(16, new Question("Jak reagują ze sobą ładunki różnoimienne?", "Przyciągają się", new Answers("Odpychają się","Nie reagują", "Iskrzą")));
        questionsDb.put(17, new Question("Jaki jest polski odpowiednik angielskiego imienia George?", "Jerzy", new Answers("Grzegorz","Gustaw","Gabriel")));
        questionsDb.put(18, new Question("Który z francuskich królów posiadał przydomek - Król Słońce?", "Ludwik XIV", new Answers("Napoleon", "Karol I WIelki", "Karol X")));
    }


//    public Map<String, String> getQuestionsDb() {
////        return questionsDb;
////    }
//
//    public void setQuestionsDb(Map<String, String> questionsDb) {
//        this.questionsDb = questionsDb;
//    }
//
//    public void addQuestionToDb(String key, String value){
//        this.questionsDb.put(key, value);
//    }
//    ta metoda nie jest konieczna ale czasem może uprościć
//    public String getQuestionFromDb(String key){
//        return questionsDb.get(key);
//    }


}
