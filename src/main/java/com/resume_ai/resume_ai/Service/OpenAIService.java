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
        String requestBody = "{"
                + "\"model\": \"text-davinci-003\","
                + "\"prompt\": \"" + ResumeAiConstants.PROMPT1.concat(pdfText).concat(ResumeAiConstants.PROMPT2) + "\","
                + "\"max_tokens\": 1000,"
                + "\"temperature\": 0.2"
                + "}";

        // Making a POST request using WebClient
        return webClient.post()
                .uri("/v1/completions")
                .header("Authorization", "Bearer " + apiKey)
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
