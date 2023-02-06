package com.example.izicapinterntest.controllers;

import com.example.izicapinterntest.services.CSVServiceInt;
import com.example.izicapinterntest.services.ChatGPTServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;

@RestController
public class ChatGPTController {
    @Autowired
    ChatGPTServiceInt chatGPTService;

    @Autowired
    CSVServiceInt csvService;

    @PostMapping("/answer")
    public ResponseEntity<String> getAnswer(@RequestParam("question") String question) {
        if (question.length() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("`question` parameter not provided.");

        // Query the ChatGPT API using the input question and retrieve the answer
        String answer = chatGPTService.queryChatGPTAPI(question);

        // Store the answer in a CSV file
        csvService.storeAnswerInCSV("answers.csv", question, answer);

        // Response with the question and it's answer
        return ResponseEntity.status(HttpStatus.OK).body(question + ";" + answer);
    }
}
