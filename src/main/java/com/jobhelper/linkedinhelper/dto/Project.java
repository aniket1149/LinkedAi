package com.jobhelper.linkedinhelper.dto;

import lombok.Data;

import java.util.List;

@Data
public class Project {
    private String projectName;
    private String description;
    private List<String> responsibilities;
    private List<String> technologies;
}
