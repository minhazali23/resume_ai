package com.resume_ai.resume_ai.Service;

import com.resume_ai.resume_ai.Exception.InvalidRegexMatchException;
import com.resume_ai.resume_ai.Model.DTO.ResumeAiDTO;
import com.resume_ai.resume_ai.Repository.ResumeAiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class ResumeAiService {
    private static final Logger logger = LoggerFactory.getLogger(ResumeAiService.class);
    private final ResumeAiRepository resumeAiRepository;
    private final EtlService etlService;
    private final OpenAiServiceClient openAiServiceClient;
    public ResumeAiService(ResumeAiRepository resumeAiRepository, EtlService etlService, OpenAiServiceClient openAiServiceClient){
        this.resumeAiRepository = resumeAiRepository;
        this.etlService = etlService;
        this.openAiServiceClient = openAiServiceClient;
    }

    public ResumeAiDTO resumeServiceOrchestrator(String emailAddress, File file) throws IOException {

        try {
            ResumeAiDTO checkIfExists = resumeAiRepository.getOneResume(emailAddress);

            if (checkIfExists.getEmailAddress() != null) {
                return checkIfExists;
            }
            String extractedPDF = etlService.extractTextFromPDF(file);
            String response = openAiServiceClient.getResponse(extractedPDF);
            ResumeAiDTO responseDTO = etlService.processResponse(response);
            responseDTO.setEmailAddress(emailAddress);
            responseDTO.setTimestamp(Timestamp.from(Instant.now()));

            resumeAiRepository.saveOneResume(responseDTO);

            return responseDTO;
        } catch (InvalidRegexMatchException ex){
            logger.error("Unable to parse Regex Expression : ", ex);
        }
        return null;
    }

}
