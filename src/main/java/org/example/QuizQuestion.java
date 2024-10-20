package org.example;

public class QuizQuestion {
    // Question Text
    private final String question;
    // Correct Answer
    private final String answer;

    // Constructor
    public QuizQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    // Properties

    public String getQuestion() {
        return question;
    }

    public String getAnswer(){
        return answer;
    }


}
