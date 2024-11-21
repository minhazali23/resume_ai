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

    public ResumeAiDTO processResponse(String response) {
        try {
            return extractContentFromResponse(response);
        } catch (Exception ex) {
            logger.error("Unable to process response from ChatGPT: ", ex);
            throw new InvalidRegexMatchException("Regex was unable to properly match the response");
        }
    }

    private ResumeAiDTO extractContentFromResponse(String response) {

        ResumeAiDTO regexMatchedDTO = new ResumeAiDTO();

        // Parse main entries
        String mainEntriesRegex = "\\*\\s*(.*?)\\s*:\\s*(.*?)\\s*Score:\\s*(\\d+)";
        Pattern mainEntriesPattern = Pattern.compile(mainEntriesRegex, Pattern.DOTALL);
        Matcher mainEntriesMatcher = mainEntriesPattern.matcher(response);

        while (mainEntriesMatcher.find()) {
            String category = mainEntriesMatcher.group(1).trim();
            String description = mainEntriesMatcher.group(2).trim();
            int score = Integer.parseInt(mainEntriesMatcher.group(3).trim());

            switch (category) {
                case "Inconsistencies":
                    regexMatchedDTO.setInconsistencies(description);
                    regexMatchedDTO.setInconsistencies_Score(score);
                    break;
                case "Exaggerated Claims":
                    regexMatchedDTO.setExaggerated_claims(description);
                    regexMatchedDTO.setExaggerated_claims_Score(score);
                    break;
                case "Lack of Detail":
                    regexMatchedDTO.setLack_of_detail(description);
                    regexMatchedDTO.setLack_of_detail_Score(score);
                    break;
                case "Frequent Job Changes":
                    regexMatchedDTO.setFrequent_job_changes(description);
                    regexMatchedDTO.setFrequent_job_changes_Score(score);
                    break;
                case "Missing Information":
                    regexMatchedDTO.setMissing_information(description);
                    regexMatchedDTO.setMissing_information_Score(score);
                    break;
                default:
                    logger.warn("Unknown category: " + category);
                    break;
            }
        }

        // Parse the summary
        String summaryRegex = "\\*\\s*Summary\\s*:\\s*(.*)";
        Pattern summaryPattern = Pattern.compile(summaryRegex, Pattern.DOTALL);
        Matcher summaryMatcher = summaryPattern.matcher(response);

        if (summaryMatcher.find()) {
            String summary = summaryMatcher.group(1).trim();
            regexMatchedDTO.setEval(summary);
        } else {
            logger.warn("Summary not found in the response.");
        }

        return regexMatchedDTO;
    }

    public static String extractTextFromPDF(File file) throws IOException {
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }
}
