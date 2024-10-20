package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizGameTest {
    // Set-up a quiz game for test
    private QuizGame createQuizGame() {
        // Create test questions
        QuizQuestion[] questions = new QuizQuestion[] {
            new QuizQuestion("What is the capital of France?", "Paris"),
            new QuizQuestion("What is the capital of Spain?", "Madrid"),
            new QuizQuestion("What is the capital of Italy?", "Rome"),
        };

        // Create a new QuizDatabase object
        QuizDatabase quizDatabase = new QuizDatabase(questions);

        // Create a new QuizGame object
        return new QuizGame(quizDatabase);
    }

    @Test
    void quizGameSuccessfullyCreated() {
        // Create a new QuizGame object
        QuizGame quizGame = createQuizGame();

        // Test the QuizGame object
        assertNotNull(quizGame);
        assertEquals(0, quizGame.getCorrectAnswers());
        assertEquals(0, quizGame.getTotalQuestions());
        assertNotNull(quizGame.getCurrentQuestion());
    }

    @Test
    void quizGameAnswerQuestion_correct() {
        // Create a new QuizGame object
        QuizGame quizGame = createQuizGame();

        // Get the current question
        QuizQuestion currentQuestion = quizGame.getCurrentQuestion();

        // Answer the current question
        quizGame.answerCurrentQuestion(currentQuestion.getAnswer());

        // Test the QuizGame object
        assertEquals(1, quizGame.getCorrectAnswers());
        assertEquals(1, quizGame.getTotalQuestions());
        assertNotNull(quizGame.getCurrentQuestion());
    }

    @Test
    void quizGameAnswerQuestion_incorrect() {
        // Create a new QuizGame object
        QuizGame quizGame = createQuizGame();

        // Get the current question
        QuizQuestion currentQuestion = quizGame.getCurrentQuestion();

        // Answer the current question
        quizGame.answerCurrentQuestion("Wrong Answer");

        // Test the QuizGame object
        assertEquals(0, quizGame.getCorrectAnswers());
        assertEquals(1, quizGame.getTotalQuestions());
        assertNotNull(quizGame.getCurrentQuestion());
    }

    @Test
    void quizGameAnswerAllQuestions() {
        // Create a new QuizGame object
        QuizGame quizGame = createQuizGame();

        // Answer all questions
        while (quizGame.getCurrentQuestion() != null) {
            QuizQuestion currentQuestion = quizGame.getCurrentQuestion();
            quizGame.answerCurrentQuestion(currentQuestion.getAnswer());
        }

        // Test the QuizGame object
        assertEquals(3, quizGame.getCorrectAnswers());
        assertEquals(3, quizGame.getTotalQuestions());
        assertNull(quizGame.getCurrentQuestion());
    }

    @Test
    void quizGameGetCurrentQuestion(){
        // Create a new QuizGame object
        QuizGame quizGame = createQuizGame();

        // Get the current question
        QuizQuestion currentQuestion = quizGame.getCurrentQuestion();

        // Test the QuizGame object
        assertNotNull(currentQuestion);
        assertEquals("What is the capital of Italy?", currentQuestion.getQuestion());
    }

    @Test
    void quizGameGetCurrentQuestion_shouldNotAdvanceToNextQuestionUnlessAnswered(){
        // Create a new QuizGame object
        QuizGame quizGame = createQuizGame();

        // Get the current question
        QuizQuestion currentQuestion = quizGame.getCurrentQuestion();

        // Test the QuizGame object
        assertNotNull(currentQuestion);
        assertEquals("What is the capital of Italy?", currentQuestion.getQuestion());

        // Should not advance to the next question unless answered
        assertEquals(currentQuestion, quizGame.getCurrentQuestion());
    }

    @Test
    void quizGameGetCurrentQuestion_shouldAdvanceToNextQuestionAfterAnswered(){
        // Create a new QuizGame object
        QuizGame quizGame = createQuizGame();

        // Get the current question
        QuizQuestion currentQuestion = quizGame.getCurrentQuestion();

        // Answer the current question
        quizGame.answerCurrentQuestion(currentQuestion.getAnswer());

        // Test the QuizGame object
        assertNotNull(currentQuestion);
        assertEquals("What is the capital of Italy?", currentQuestion.getQuestion());

        // Should advance to the next question after answered
        assertNotEquals(currentQuestion, quizGame.getCurrentQuestion());
    }
}