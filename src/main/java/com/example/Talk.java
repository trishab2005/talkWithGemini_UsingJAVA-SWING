package com.example;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class Talk {

    //Talk with Gemini
    static String askQuestion(String question) {
        //try-with-resource in java 7 onwards
        GenerateContentResponse response = null;
        try (Client c = new Client()) {
            IO.println("client is ready " + c + " hashcode is " + c.hashCode());
            response = c.models.generateContent(
                    "gemini-2.5-flash",
                    question,
                    null
            );

        } catch (Exception e) {
            IO.println("Exception " + e);
        }

        return response.text().toUpperCase();
    }
}
