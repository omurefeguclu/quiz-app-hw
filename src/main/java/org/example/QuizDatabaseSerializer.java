package org.example;

import org.json.*;
import java.io.*;

public class QuizDatabaseSerializer {
    // Serialize QuizDatabase object to a json file
    public static String serialize(QuizDatabase quizDatabase) {
        // Create a new json array
        JSONArray jsonArray = new JSONArray();

        // Loop through each question in the quiz database
        for (QuizQuestion question : quizDatabase.getQuestions()) {
            // Create a new json object
            JSONObject jsonObject = new JSONObject();

            // Add question and answer to the json object
            jsonObject.put("question", question.getQuestion());
            jsonObject.put("answer", question.getAnswer());

            // Add json object to the json array
            jsonArray.put(jsonObject);
        }

        // Create a new json object
        JSONObject jsonObject = new JSONObject();

        // Add questions array to the json object
        jsonObject.put("questions", jsonArray);

        // Return json object as a string
        return jsonObject.toString();
    }

    // Deserialize QuizDatabase object from a json file
    public static QuizDatabase deserialize(String jsonString) {
        // Create a new json object
        JSONObject jsonObject = new JSONObject(jsonString);

        // Get questions array from json object
        JSONArray questionsArray = jsonObject.getJSONArray("questions");

        // Create a new array of QuizQuestion objects
        QuizQuestion[] questions = new QuizQuestion[questionsArray.length()];

        // Loop through each question in the json array
        for (int i = 0; i < questionsArray.length(); i++) {
            // Get question object from json array
            JSONObject questionObject = questionsArray.getJSONObject(i);

            // Get question and answer from question object
            String question = questionObject.getString("question");
            String answer = questionObject.getString("answer");

            // Create a new QuizQuestion object
            questions[i] = new QuizQuestion(question, answer);
        }

        // Return new QuizDatabase object
        return new QuizDatabase(questions);
    }


    // Deserialize QuizDatabase object from a json file
    public static QuizDatabase deserializeFromFile(String jsonFile) {
        // Read json file
        String jsonString = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize json string
        return deserialize(jsonString);
    }

}
