package com.jobhelper.linkedinhelper.dto;

import lombok.Data;

@Data
public class LinkedinSections {
        private ContactInfo contactInfo;
        private String headline;
        private String about;
        private Experience[] experience;
        private Education[] education;
        private String[] skills;
        private Project[] projects;
        private Experience[] volunteerExperience;
        private Accomplishments accomplishments;
        private String[] interests;
        private String comments;
        private String[] jobRolesSuggested;
        private String referralMessage;
}
