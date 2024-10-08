package com.jobhelper.linkedinhelper.controller;

import com.jobhelper.linkedinhelper.dto.LinkedinSections;
import com.jobhelper.linkedinhelper.dto.UserReq;
import com.jobhelper.linkedinhelper.services.GenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/jobhelp")
@RequiredArgsConstructor
public class GenController {

    private final GenAiService genAiService;

    @PostMapping("/resumeAnalyze")
    public ResponseEntity<String> resumeAnalyze(@RequestBody UserReq userReq) {
        String gptResponse = genAiService.getChatGptResponse(userReq);
        if (gptResponse == null || gptResponse.isEmpty() || gptResponse.isBlank()) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the resume.");
        }
        return  ResponseEntity.ok(gptResponse);
    }
    @PostMapping("/lnkdtest")
    public ResponseEntity<String> linkedinTest(@RequestBody UserReq userReq) {
        return  ResponseEntity.ok(genAiService.chatWithMemory(userReq));
    }

    @PostMapping("/lnkdsect")
    public ResponseEntity<LinkedinSections> linkedinSections(@RequestBody UserReq userReq) {
        return  ResponseEntity.ok(genAiService.getLinkedinSections(userReq));
    }

    @PostMapping("/jobRoles")
    public ResponseEntity<List<String>> getJobRoles(@RequestBody UserReq userReq) {
        return  ResponseEntity.ok(genAiService.getRecommendedJobRole(userReq));
    }

}
