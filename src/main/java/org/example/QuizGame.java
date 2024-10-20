package org.example;

import java.util.Collections;
import java.util.Stack;

public class QuizGame {
    // Database
    private final QuizDatabase quizDatabase;

    private Stack<QuizQuestion> questions = new Stack<>();

    // Fields
    private int correctAnswers = 0;
    private int totalQuestions = 0;

    private QuizQuestion currentQuestion;

    // Constructor
    public QuizGame(QuizDatabase quizDatabase) {
        this.quizDatabase = quizDatabase;

        // Add questions to the stack
        for (QuizQuestion question : quizDatabase.getQuestions()) {
            questions.push(question);
        }
    }

    // Answer the current question, return true if the answer is correct
    public boolean answerCurrentQuestion(String answer) {
        // Check if the answer is correct
        boolean isCorrect = currentQuestion.getAnswer().equalsIgnoreCase(answer);

        // Increment the correct answers if the answer is correct
        if (isCorrect) {
            correctAnswers++;
        }

        // Increment the total questions
        totalQuestions++;

        // Clear the current question
        currentQuestion = null;

        return isCorrect;
    }

    // Get the current question
    public QuizQuestion getCurrentQuestion() {
        if (currentQuestion != null) {
            return currentQuestion;
        }

        // Check if there are any questions left
        if (questions.isEmpty()) {
            return null;
        }

        // Get the next question
        currentQuestion = questions.pop();

        return currentQuestion;
    }

    // Getters
    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

}
