package com.resume_ai.resume_ai.Service;
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
    public Mono<String> getResponseFromOpenAI(String prompt) {
        String requestBody = "{"
                + "\"model\": \"text-davinci-003\","
                + "\"prompt\": \"" + prompt + "\","
                + "\"max_tokens\": 1000,"
                + "\"temperature\": 0.5"
                + "}";

        // Making a POST request using WebClient
        return webClient.post()
                .uri("/v1/completions")
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.just("Error: " + e.getMessage()));
    }

}
