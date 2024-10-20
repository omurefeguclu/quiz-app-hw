package org.example;

public class QuizDatabaseSeed {
    public static final String jsonTest1 = """
        {
            "questions": [
                {
                    "question": "What is the capital of France?",
                    "answer": "Paris"
                },
                {
                    "question": "What is the capital of Germany?",
                    "answer": "Berlin"
                },
                {
                    "question": "What is the capital of Italy?",
                    "answer": "Rome"
                }
            ]
        }
            """;

    // JSON string for testing deserialization with different questions
    public static final String jsonTest2 = """
        {
            "questions": [
                {
                    "question": "What is the capital of France?",
                    "answer": "Paris"
                },
                {
                    "question": "What is the capital of Spain?",
                    "answer": "Madrid"
                }
            ]
        }
            """;
}
