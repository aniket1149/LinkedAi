package com.jobhelper.linkedinhelper.services;

import com.jobhelper.linkedinhelper.dto.LinkedinSections;
import com.jobhelper.linkedinhelper.dto.UserReq;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenAiServiceImpl implements GenAiService {
    private HashMap<String, String> sectionsMapCommands;
    private final GenAiWithMemory assistant;


    private final OpenAiChatModel model = OpenAiChatModel.builder()
            .apiKey("demo")
            .modelName(OpenAiChatModelName.GPT_4_O)
            .build();


    @Override
    public String getChatGptResponse(UserReq userReq) {
        return model.generate("Analyze this resume and provide me 5 key points that you like about me and also highligh which position would be suited for me based on this resume, send the response back in plain text format no ** or any other special characters or markdowns : "+userReq.getResume());
    }

    @Override
    public String chatWithMemory(UserReq userReq) {
        return assistant.chat(Integer.valueOf(userReq.getUserId()), userReq.getResume());
    }

    @Override
    public LinkedinSections getLinkedinSections(UserReq userReq) throws Exception {
        return assistant.getLinkedinSections(Integer.valueOf(userReq.getUserId()), userReq.getResume());
    }

    @Override
    public List<String> getRecommendedJobRole(UserReq userReq) {
        return assistant.getRecommendedJobRole(Integer.valueOf(userReq.getUserId()), userReq.getResume());
    }

}
