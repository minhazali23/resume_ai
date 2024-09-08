package com.resume_ai.resume_ai.Controller;

import com.resume_ai.resume_ai.Model.DTO.ResumeAiDTO;
import com.resume_ai.resume_ai.Service.ResumeAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@RequestMapping("/resumeAi")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    ResumeAiService resumeAiService;
    @GetMapping("/{emailAddress}/{file}")
    public ResumeAiDTO sendRequest(@PathVariable(value = "emailAddress") String emailAddress, @PathVariable(value = "file") File file) throws IOException {
        return resumeAiService.resumeServiceOrchestrator(emailAddress, file);
    }
}
