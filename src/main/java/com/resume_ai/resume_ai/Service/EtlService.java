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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EtlService {
    private static final Logger logger = LoggerFactory.getLogger(EtlService.class);
    private static final Pattern regexFieldsPattern = Pattern.compile(
            "\\*\\s*(.*?)\\s*: (.*?)\\s*Score: (\\d+)|\n" +
                    "\\*\\s*(Summary)\\s*: (.*)", Pattern.DOTALL);

    public ResumeAiDTO processResponse(String response) {
        try {

            ResumeAiDTO getExtractedContent = extractContentFromResponse(response);

        } catch (NullPointerException ex) {
            logger.error("Unable to process response from ChatGPT: ", ex);
            throw new InvalidRegexMatchException("Regex was unable to properly match the response");
        }
        return null;
    }

    private ResumeAiDTO extractContentFromResponse(String response){

        Matcher matcher = regexFieldsPattern.matcher(response);

        if(matcher.find()){
            ResumeAiDTO regexMatchedDTO = new ResumeAiDTO();

            regexMatchedDTO.setInconsistencies(matcher.group(2).trim());
            regexMatchedDTO.setInconsistencies_Score(Integer.parseInt(matcher.group(3).trim()));

            regexMatchedDTO.setExaggerated_claims(matcher.group(5));
            regexMatchedDTO.setExaggerated_claims_Score(Integer.parseInt(matcher.group(6).trim()));

            regexMatchedDTO.setLack_of_detail(matcher.group(8));
            regexMatchedDTO.setLack_of_detail_Score(Integer.parseInt(matcher.group(9).trim()));

            regexMatchedDTO.setFrequent_job_changes(matcher.group(11).trim());
            regexMatchedDTO.setFrequent_job_changes_Score(Integer.parseInt(matcher.group(12).trim()));

            regexMatchedDTO.setMissing_information(matcher.group(14).trim());
            regexMatchedDTO.setMissing_information_Score(Integer.parseInt(matcher.group(15).trim()));

            regexMatchedDTO.setEval(matcher.group(17).trim());
        }

        return null;
    }

    public static String extractTextFromPDF(File file) throws IOException {
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }
}