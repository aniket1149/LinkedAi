package com.jobhelper.linkedinhelper.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Data
public class UserReq {
    private String userId;
    @Nullable
    private String resume;
}
