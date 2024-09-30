package com.resume_ai.resume_ai.Service;

import com.resume_ai.resume_ai.Constants.ResumeAiConstants;
import io.github.stefanbratanov.jvm.openai.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenAiServiceClient {

    private final OpenAI openAI;
    private final ChatClient chatClient;

    public OpenAiServiceClient(@Value("${openai.api.key}") String apiKey) {
        this.openAI = OpenAI.newBuilder(apiKey).build();
        this.chatClient = openAI.chatClient();
    }

    public String getResponse(String fileContents) {

        String prompt = ResumeAiConstants.PROMPT1 + fileContents + ResumeAiConstants.PROMPT2;

        CreateChatCompletionRequest createChatCompletionRequest = CreateChatCompletionRequest.newBuilder()
                .model(OpenAIModel.GPT_4)
                .temperature(0.1)
                .message(ChatMessage.userMessage(prompt))  // Use the provided prompt
                .build();

        ChatCompletion chatCompletion = chatClient.createChatCompletion(createChatCompletionRequest);

        return chatCompletion.choices().get(0).message().content();
    }
}
