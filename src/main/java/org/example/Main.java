package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Play QuizGame with seed data
        QuizDatabase database = QuizDatabaseSerializer.deserialize(QuizDatabaseSeed.jsonTest1);

        // Create a new QuizGame instance
        QuizGame quizGame = new QuizGame(database);

        // Welcome message
        System.out.println("Welcome to the Quiz Game!");

        while(quizGame.getCurrentQuestion() != null){
            // Display the current question
            System.out.println(quizGame.getCurrentQuestion().getQuestion());

            // Get the user's answer with a prompt: "Your answer: "
            String userAnswer = System.console().readLine("Your answer: ");

            // Send the user's answer to the QuizGame
            boolean correct = quizGame.answerCurrentQuestion(userAnswer);

            // Display the result of the user's answer
            if(correct){
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }

            // Display the game state: "Score: 0/0"
            System.out.println("Score: " + quizGame.getCorrectAnswers() + "/" + quizGame.getTotalQuestions());
        }

        // Display the final score: "Final Score: 0/0"
        System.out.println("Final Score: " + quizGame.getCorrectAnswers() + "/" + quizGame.getTotalQuestions());

        // Display the message: "Game Over!"

        System.out.println("Game Over!");

    }
}