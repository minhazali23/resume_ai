package com.resume_ai.resume_ai.Service;

import com.resume_ai.resume_ai.Exception.InvalidRegexMatchException;
import com.resume_ai.resume_ai.Model.DTO.ResumeAiDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
@Service
public class EtlService {
    private static final Logger logger = LoggerFactory.getLogger(EtlService.class);
    public ResumeAiDTO processResponse(String response) {
        try {

            ResumeAiDTO extractedResume;

            String getExtractedContent = extractContentFromResponse(response);
            extractedResume = loadFieldsToDTO(getExtractedContent);
//            validateChatGptResponse(extractedProduct);
//            validateIsItHalal(extractedProduct);
//
//            if (extractedProduct != null) {
//                return extractedProduct;
//            }

        } catch (NullPointerException ex) {
            logger.error("Unable to process response from ChatGPT: ", ex);
            throw new InvalidRegexMatchException("Regex was unable to properly match the response");
        }
        return null;
    }

    private ResumeAiDTO loadFieldsToDTO(String loadThisResponse){
        return null;
    }
    private String extractContentFromResponse(String response){
        return "";
    }
    public static String extractTextFromPDF(File file) throws IOException {
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }
}