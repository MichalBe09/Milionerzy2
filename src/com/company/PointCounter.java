package com.company;

import com.company.Game.Game;
import com.company.baza_pytań.QuestionsDB;

public class PointCounter {             // ta klasa miała służyć jako metoda na cały mechanizm gry
    Game game = new Game();
    QuestionsDB questionsDB = new QuestionsDB();

    public String  check(String answer){
        if (questionsDB.getQuestionsDb().containsValue(game.answer)){
            return "t";
        }else {
            return "nr";
        }

    }
}
