package com.jobhelper.linkedinhelper.services;

import com.jobhelper.linkedinhelper.dto.LinkedinSections;
import com.jobhelper.linkedinhelper.dto.UserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GenAiService {
    String getChatGptResponse(UserReq userReq);
    String chatWithMemory(UserReq userReq);
    LinkedinSections getLinkedinSections(UserReq userReq);
    List<String> getRecommendedJobRole(UserReq userReq);
}
