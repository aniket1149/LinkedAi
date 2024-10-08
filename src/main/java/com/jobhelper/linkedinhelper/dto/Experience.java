package com.jobhelper.linkedinhelper.dto;

import lombok.Data;

import java.util.List;

@Data
public class Experience {
    private String company;
    private String location;
    private String role;
    private String dates;
    private List<Project> projects;
    private List<String> responsibilities;
}
