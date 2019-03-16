package com.company;

import java.util.*;

public class QuestionsController {
    public static void main(String[] args) {


        String randomQ;
        String answer;
        String exit = "Wyjście";
        int counter = 1;
        int r;
        int lifebuoy = 0; // w sytuacji podbramkowej, gdy gracz będzie zagrożony przegraną i nie będzie znał odpowiedzi na pytanie, będzie miał możliwość wpisania wybrania opcji "skip", co spowoduje przeskok do następnego pytania bez utraty punktu. Koło ratunkowe może zostać użyte tylko 3 razy.

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        QuestionsDB questionsDB = new QuestionsDB(); // odnośnik do klasy w której znajdują się pytania, oraz gettery z setterami, bez niego nie byłoby możliwe przywoływanie jej zawartości, znosi konieczność dziedziczenia

        List<String> listOfQuestions = new ArrayList<String>(questionsDB.getQuestionsDb().keySet());
        System.out.println("Witamy w Milionerach ! Przed Tobą test z wiedzy ogólnej, oraz pierwsze pytanie. Powodzenia ! Pamiętaj że zawsze możesz zakończyć grę klikając (Wyjście)");

        do {
            randomQ = listOfQuestions.get(random.nextInt(listOfQuestions.size()));
            System.out.println("Podaj odpowiedź:");
            System.out.println(randomQ);
            answer = scanner.nextLine();
            r = random.nextInt(1000);               // generowanie losowej liczby, z której potem wyciągamy modulo <- autorski mechanizm do randomowych pytań czy gracz jest pewny swojego wyboru. Szansą na pojawienie się pytania można operować np. zmieniając int na double, lub manipulując modulo.
            System.out.println(r);
            if (questionsDB.getQuestionsDb().containsValue(answer) && r % 2 == 0) { // ten if sprawdza czy warunek do wygenerowania zwodzącego pytania został wykonany
                System.out.println("Jesteś pewien? Zastanów się jeszcze raz :)");
                answer = scanner.nextLine();
                if (questionsDB.getQuestionsDb().containsValue(answer)) {
                    System.out.println("Prawidłowa odpowiedź !");                   // jeśli gracz pomimo dodatkowego pytania nie zawaha się, otrzymuje punkt
                    counter++;
                } else {
                    System.out.println("Zła odpowiedź !");                         // jeśli uda się wzbudzić w graczu presję i zmieni zdanie, niestety traci punkt
                    counter--;
                    if (counter == 0){
                        System.out.println("Straciłes wszystkie punkty ! Przegrałeś !");
                    }
                }
            } else if (questionsDB.getQuestionsDb().containsValue(answer)) {
                System.out.println("Prawidłowa odpowiedź !");                       // gdy warunek dodatkowego pytania nie zostanie spełniony, a gracz odpowie dobrze, naturalnie otrzymuje punkt
                counter++;
            } else if (answer.equals(exit)) {
                System.out.println("Zakończyłeś grę. Udało Ci się zdobyc " + counter + " punktów");         // konczy grę i pokazuję liczbę punktów, jakie udało nam się zdobyć


            } else if (answer.equals("skip")){      // komenda koła ratunkowego
                lifebuoy++;
                if (lifebuoy <= 3){
                    System.out.println("Pominięcie pytania ! Wykorzystałeś już: "+lifebuoy+" z 3 przysługujących Ci kół ratunkowych");  // jeśli gracz ma dostępne koła, może pominąć pytanie na które nie zna odpowiedzi bez konwekwencji
                }else if (lifebuoy > 3){
                    counter--;
                    System.out.println("Nie masz już dostępnych kół ratunkowych ! Tracisz punkt !");// jeśli gracz wykorzystał już wszystkie koła, traci punkt
                    if (counter == 0){
                        System.out.println("Straciłes wszystkie punkty ! Przegrałeś !");
                    }
                }
            } else if (!questionsDB.getQuestionsDb().containsValue(answer) && r % 2 == 0) {         // jw. sprawdza, czy warunek do wyświetlenia dodatkowego pytania został spełniony, przy udzieleniu złej odpowiedzi pytanie dodatkowe pełni raczej funkcję "koła ratunkowego", choć gracz nie jest o tym świadomy.
                System.out.println("Jesteś pewien ? Zastanów się jeszcze raz :)");
                answer = scanner.nextLine();
                if (!questionsDB.getQuestionsDb().containsValue(answer)) {
                    System.out.println("Zła odpowiedź !");                                  // jeśli gracz mimo pytania pomocniczego odpowie źle, naturalnie traci punkt
                    counter--;
                    if (counter == 0){
                        System.out.println("Straciłes wszystkie punkty ! Przegrałeś !");
                    }
                } else if (questionsDB.getQuestionsDb().containsValue(answer)) {
                    System.out.println("Odpowiedziałeś dobrze za drugim razem. Udało Ci się nie stracić punktu, ale też żadnego nie zyskujesz !");     // jeśli gracz poprawi swoją odpowiedź na poprawną nie traci punktu, ale też żadnego nie zyskuje
                }
            }else if (!questionsDB.getQuestionsDb().containsValue(answer)) {
                    System.out.println("Zła odpowiedź !");                          // jeśli warunek pytania pomocniczego nie zostanie spełniony, a gracz udzielił złej odpowiedzi, traci punkt
                    counter--;
                if (counter == 0){
                    System.out.println("Straciłes wszystkie punkty ! Przegrałeś !");
                }
            }

            }while (!answer.equals(exit) && counter > 0);                     // gra trwa do momentu aż gracz sam ją zakończy
        }
    }

