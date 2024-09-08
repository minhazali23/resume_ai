package com.resume_ai.resume_ai.Service;

import com.resume_ai.resume_ai.Constants.ResumeAiConstants;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;
    private final WebClient webClient;

    public OpenAIService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getResponseFromOpenAI(String pdfText) {
        // Construct the prompt text
        String prompt = ResumeAiConstants.PROMPT1 + pdfText + ResumeAiConstants.PROMPT2;

        // Construct the request body with proper escaping
        String requestBody = "{"
                + "\"model\": \"gpt-4-turbo\","
                + "\"messages\": ["
                + "{\"role\": \"user\", \"content\": \"" + prompt.replace("\"", "\\\"") + "\"}"
                + "],"
                + "\"max_tokens\": 1000,"
                + "\"temperature\": 0.2"
                + "}";

        return webClient.post()
                .uri("/v1/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> {
                    // Log the error
                    System.out.println("Error during API call: " + e.getMessage());
                    // Return a fallback response
                    return Mono.just("Error occurred: " + e.getMessage());
                });
    }
}
