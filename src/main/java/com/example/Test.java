package com.example;


public class Test {
    static void main() {
        IO.println("java version is "+System.getProperty("java.version"));
        String question=IO.readln("Ask the question to Gemini...");
        String response=Talk.askQuestion(question);
        IO.println("Gemini AI: "+response);
    }
}