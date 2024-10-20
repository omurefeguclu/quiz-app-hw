import org.example.QuizDatabase;
import org.example.QuizDatabaseSeed;
import org.example.QuizDatabaseSerializer;

import org.example.QuizQuestion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class QuizDatabaseSerializerTests {



    // Parameterized test method for deserialization
    private void testDeserializeQuizDatabase(String json, int expectedLength) {
        // Deserialize the QuizDatabase object
        QuizDatabase quizDatabase = QuizDatabaseSerializer.deserialize(json);

        // Test the QuizDatabase object
        Assertions.assertNotNull(quizDatabase);
        Assertions.assertEquals(expectedLength, quizDatabase.getQuestions().length);
    }


    // Parameterized test for deserialization
    @Test
    public void testDeserializeQuizDatabase_1() {
        testDeserializeQuizDatabase(QuizDatabaseSeed.jsonTest1, 3);

    }
    @Test
    public void testDeserializeQuizDatabase_2() {
        testDeserializeQuizDatabase(QuizDatabaseSeed.jsonTest2, 2);
    }

    // Test for serialization
    @Test
    public void testSerializeQuizDatabase() {
        // Create test questions
        QuizQuestion[] questions = new QuizQuestion[] {
            new QuizQuestion("What is the capital of France?", "Paris"),
        };

        // Create a new QuizDatabase object
        QuizDatabase quizDatabase = new QuizDatabase(questions);

        // Serialize the QuizDatabase object
        String json = QuizDatabaseSerializer.serialize(quizDatabase);

        // Deserialize the QuizDatabase object
        QuizDatabase deserializedQuizDatabase = QuizDatabaseSerializer.deserialize(json);

        // Test the deserialized QuizDatabase object
        Assertions.assertNotNull(deserializedQuizDatabase);
        Assertions.assertEquals(1, deserializedQuizDatabase.getQuestions().length);

        // Test the deserialized QuizQuestion object
        QuizQuestion deserializedQuestion = deserializedQuizDatabase.getQuestions()[0];
        Assertions.assertEquals("What is the capital of France?", deserializedQuestion.getQuestion());
        Assertions.assertEquals("Paris", deserializedQuestion.getAnswer());
    }
}
