package com.jobhelper.linkedinhelper.config;

import com.jobhelper.linkedinhelper.services.GenAiWithMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Configuration
public class AiConfig {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    @Bean
    public GenAiWithMemory genAiWithMemory(){
        return AiServices.builder(GenAiWithMemory.class)
                .chatLanguageModel(chatLanguageModel())
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }
    @Bean
    public ChatLanguageModel chatLanguageModel() {
       return OpenAiChatModel.builder()
                .apiKey(openAiApiKey)
                .organizationId("org-N3kLzCDDNnyAV7Ex19NS2GYN")
                .timeout(Duration.of(60, ChronoUnit.SECONDS))
                .modelName(OpenAiChatModelName.GPT_4_O)
                .build();
    }
}
