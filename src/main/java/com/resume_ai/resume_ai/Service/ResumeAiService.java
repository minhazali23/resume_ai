package com.resume_ai.resume_ai.Service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ResumeAiService {

    public String extractAndProcessPDF(File file, String promptTemplate) throws IOException {
        return PdfExtractorService.extractTextFromPDF(file);
    }
}
