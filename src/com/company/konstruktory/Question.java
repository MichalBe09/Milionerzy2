package com.company.konstruktory;

import com.company.konstruktory.Answers;

public class Question {

    String question;
    String answer;
    Answers answers;


    public Question(String question, String answer, Answers answers) {
        this.question = question;
        this.answer = answer;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }
}
