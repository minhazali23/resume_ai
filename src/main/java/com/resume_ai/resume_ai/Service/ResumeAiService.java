package com.resume_ai.resume_ai.Service;

import com.resume_ai.resume_ai.Model.DTO.ResumeAiDTO;
import com.resume_ai.resume_ai.Repository.ResumeAiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ResumeAiService {
    private static final Logger logger = LoggerFactory.getLogger(ResumeAiService.class);
    private final ResumeAiRepository resumeAiRepository;
    private final OpenAIService openAIService;
    private final EtlService etlService;

    private final OpenAiServiceClient openAiServiceClient;
    public ResumeAiService(ResumeAiRepository resumeAiRepository, OpenAIService openAIService, EtlService etlService, OpenAiServiceClient openAiServiceClient){
        this.resumeAiRepository = resumeAiRepository;
        this.openAIService = openAIService;
        this.etlService = etlService;
        this.openAiServiceClient = openAiServiceClient;
    }

    public ResumeAiDTO resumeServiceOrchestrator(String emailAddress, File file) throws IOException {

//        ResumeAiDTO checkIfExists = resumeAiRepository.getOneResume(emailAddress);
//
//        if(checkIfExists.getEmailAddress() != null){
//            return checkIfExists;
//        }

        String extractedPDF = etlService.extractTextFromPDF(file);
        String response = openAiServiceClient.getResponse(extractedPDF);
//        String response = openAIService.getResponseFromOpenAI(extractedPDF).toString();
        System.out.println(response);
        ResumeAiDTO newResumeRequest = new ResumeAiDTO();
        newResumeRequest.setEmailAddress(emailAddress);
        return null;
    }

}
