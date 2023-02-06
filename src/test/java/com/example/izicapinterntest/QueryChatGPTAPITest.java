package com.example.izicapinterntest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.izicapinterntest.services.ChatGPTService;
import org.junit.Test;

public class QueryChatGPTAPITest {
    @Test
    public void testQueryChatGPTAPI() {
        String question = "What is the capital of France?";
        String expectedAnswer = "Paris.";

        ChatGPTService chatGPTService = new ChatGPTService();
        String answer = chatGPTService.queryChatGPTAPI(question);

        assertEquals(answer, expectedAnswer);
    }
}
