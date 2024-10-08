package com.jobhelper.linkedinhelper.dto;

import lombok.Data;

import java.util.List;

@Data
public class Education {
    private String degree;
    private String institution;
    private String location;
    private String dates;
    private List<String> honors;
}
