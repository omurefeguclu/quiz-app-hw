

package org.example;

public class QuizDatabase {
    // Questions
    private final QuizQuestion[] questions;

    // Properties
    public QuizQuestion[] getQuestions() {
        return questions;
    }

    // Constructor
    public QuizDatabase(QuizQuestion[] questions) {
        this.questions = questions;
    }

    // Static method to load quiz options from a json file
    public static QuizDatabase loadFromJson(String jsonFile) {

        // Load questions from json file
        QuizQuestion[] questions = new QuizQuestion[0];

        // Return new QuizOptions object
        return new QuizDatabase(questions);

    }
}
