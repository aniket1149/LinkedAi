package com.jobhelper.linkedinhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LinkedinHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkedinHelperApplication.class, args);
    }

}
