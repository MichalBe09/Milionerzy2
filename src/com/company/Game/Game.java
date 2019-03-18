package com.company.Game;

import com.company.PointCounter;
import com.company.konstruktory.Question;
import com.company.baza_pytań.QuestionsDB;

import java.util.*;

public class Game {
    public String answer;           // String przechowujący poprawną odpowiedź
    String exit = "Wyjście";        // polecenie kończące grę i wyświetlające zdobyte punkty
    String skip = "skip";           // koło ratunkowe, pozwala podczas jednej gry 3 razy przeskoczyć pytanie, gdy nie znamy na nie odpowiedzi, a nie chcemy stracić punktu
    int lifebuoy = 0;               // licznik użytych kół ratunkowych, po każdym użyciu gra wyświetla ile z nich gracz już zużył. Jeśli gracz przekroczy dozwoloną wartość 3 wykorzystań, przy kolejnym użyciu traci punkty
    int counter =1;                 // licznik punktów. Jako, że jednym z warunków zakończenia gry jest utrata wszystkich punktów startuje od wartości 1
    int r;                          // zmienna przechowująca randomowo wygenerowaną liczbę, część mechanizmu randomowo pokazujących się pytań zwodzących i pytań pomocniczych

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    QuestionsDB questionsDB = new QuestionsDB();
    Communicates communicates = new Communicates();
    PointCounter pointCounter;

    public void run(String playerName) {            // gra jako metoda
        questionsDB.addStartDataBase();
        System.out.println(playerName+communicates.welcome);

        do {
            Question question = questionsDB.getQuestionsDb().get(random.nextInt(questionsDB.getQuestionsDb().size()));      // pobieranie randomowego pytania i zestawu odpowiedzi z listy znajdującej się w klasie QuestionsDB
            String quest = question.getQuestion();         // pobieranie klucza mapy z wylosowanego indeksu, klucze obiektu "Question" służą jako pytania
            String rightAnswer = question.getAnswer();      // pobieranie wartości randomowo wygenerowanego obiektu "Question", wartości służą jako poprawne odpowiedzi
            String wrongAnswer1 = question.getAnswers().getAnswer1();       // pobieranie wartości jednej ze złych odpowiedzi
            String wrongAnswer2 = question.getAnswers().getAnswer2();       // pobieranie wartości jednej ze złych odpowiedzi
            String wrongAnswer3 = question.getAnswers().getAnswer3();       // pobieranie wartości jednej ze złych odpowiedzi

            List<String> answers = new ArrayList<>();      // lista do której są wrzucane wygenerowane losowo odpowiedzi, będą następnie z niej drukowane randomowo
            answers.add(rightAnswer);
            answers.add(wrongAnswer1);
            answers.add(wrongAnswer2);
            answers.add(wrongAnswer3);
            Collections.shuffle(answers);   // przetasowanie pozycji na liście aby je wydrukować w losowej kolejności


            System.out.println(communicates.answerPlease);
            System.out.println();
            System.out.println(quest);          // drukowanie randomowo wylosowanego pytania
            for (String answerss : answers){
                System.out.println(answerss);}       // drukowanie propozycji pytań w losowej kolejności ( wcześniej drukowało w narzuconej kolejności, tak że pod "A." była zawsze prawidłowa odpowiedź
            System.out.println();
            System.out.println("Odpowiedź:");
            answer = scanner.nextLine();
            r = random.nextInt(10000);      // losowanie randomowej liczby, część mechanizmu pytań dodatkowych
            if (answer.equals(rightAnswer) && r % 2 == 0) {     // sprawdzenie czy randomowa liczba spełnia warunki do wyświetlenia pytania zwodzącego, częstotliwością pojawiania się pytań można manipulować zmieniając na przykład modulo
                System.out.println(communicates.areYouSure);    // jeśli liczba spełnia warunek, zostaje wydrukowane pytanie zwodzące
                answer = scanner.nextLine();
                if (answer.equals(rightAnswer)) {
                    counter++;                                  // po udzieleniu wlasciwej odpowiedzi gracz dostaje punkt i przechodzi do następnego pytania
                    System.out.println(communicates.right+(counter-1)); // odejmujemy od licznika punktów 1 pkt, ponieważ biorąc pod uwagę mechanikę gry, gra musi się rozpocząc z ilością pkt większą od 0
                } else if (!answer.equals(rightAnswer)){
                    counter--;                                  // jeśli uda się zmylić gracza i zmieni zdanie na złą odpowiedź, traci punkt
                    System.out.println(communicates.secondWrong+(counter-1));
                    if (counter == 0) {                         // jeśli gracz stracił wszystkie punkty, przegrywa
                        System.out.println(communicates.lost);
                    }
                }
            }else if (answer.equals(skip)) {
                lifebuoy++;                     // funkcja koła ratunkowego
                if (lifebuoy <= 3) {            // jeśli gracz posiada dostępne koła, licznik zużytych zostaje zwiększony, a gracz przechodzi bez utraty punktów do następnego pytania
                    System.out.println(communicates.skip + lifebuoy);
                }else if (lifebuoy > 3){        // jeśli gracz zużył już wszystkie koła i próbuje użyć komendy mimo to, traci punkt
                    counter--;
                    System.out.println(communicates.noSkipsLeft+counter);
                    if (counter == 0){          // jeśli gracz stracił wszystkie punkty, przegrywa
                        System.out.println(communicates.lost);
                    }
                }
            }else if (answer.equals(exit)){
                System.out.println(communicates.exitGame+(counter-1));  // funkcja pozwalająca zakończyć grę w dowolnym momencie
            }
            else if (answer.equals(rightAnswer)) {
                counter++;                                              // gdy udzielono dobrej odpowiedzi, dostajemy punkt
                System.out.println(communicates.right+(counter-1));
            } else if (!answer.equals(rightAnswer) && r % 2 == 0) {     // sprawdzenie czy randomowa liczba spełnia warunki do wyświetlenia pytania pomocniczego, częstotliwością pojawiania się pytań można manipulować zmieniając na przykład modulo
                System.out.println(communicates.areYouSure);
                answer = scanner.nextLine();
                if (answer.equals(rightAnswer)) {
                    System.out.println(communicates.secondRight+(counter-1));       // jeśli gracz odpowie dobrze na pomocnicze pytanie, nie traci punktu, ale też żadnego nie zdobywa
                } else {
                    counter--;
                    System.out.println(communicates.wrong+(counter-1));
                    if (counter == 0) {
                        System.out.println(communicates.lost);
                    }
                }
            } else if (!answer.equals(rightAnswer)) {       // jeśli gracz odpowie źle, a warunek dla losowego pytania pomocniczego nie został spełniony, traci punkt
                counter--;
                System.out.println(communicates.wrong+(counter-1));
                if (counter == 0){
                    System.out.println(communicates.lost);
                }
            }
        } while (!answer.equals(exit) && counter > 0);          // gra toczy się póki gracz jej nie przerwie, lub nie straci wszystkich punktów


    }
}

