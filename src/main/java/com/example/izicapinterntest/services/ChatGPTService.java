package com.example.izicapinterntest.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGPTService implements ChatGPTServiceInt {
    @Value("${openai.endpoint}")
    String OPENAI_ENDPOINT;

    @Value("${openai.key}")
    String OPENAI_APIKEY;

    public String queryChatGPTAPI(String question) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + OPENAI_APIKEY);
            String payload = "{\"model\": \"text-davinci-003\",\"prompt\":\"" + question + "\",\"max_tokens\":4000,\"temperature\":1.0}";

            HttpEntity<String> entity = new HttpEntity<>(payload, headers);
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.postForObject(OPENAI_ENDPOINT, entity, String.class);

            // Extract the answer from the response
            JSONObject jsonResponse = new JSONObject(response);
            String answer = jsonResponse.getJSONArray("choices").getJSONObject(0).getString("text");

            answer = answer.replaceAll("\n", "");

            return answer;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return "Error: Unable to retrieve answer from the ChatGPT API.\n" + e.toString();
        }
    }
}
