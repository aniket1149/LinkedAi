package com.jobhelper.linkedinhelper.services;

import com.jobhelper.linkedinhelper.dto.LinkedinSections;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

import java.util.List;

public interface GenAiWithMemory {
    @SystemMessage(
            """
                    you are a linkedin assistant. A user has come to you asking help in setting up their linkedin profile. 
                    you have to analuze the resume text given to you.
                    you can skip greetings to the user be precise and give answers direct so that user just has to copy paste it in the browser window.
                    also make sure your response  doesn't extend 500characters.
                    if you don't understand it just tell the did not understand no guessing you have to stay within the bounds of resume but also make sure to showoff skills that are hidden in the resume as resume and linkedin should be exactly the same.
                    """
    )
    String chat(@MemoryId int memoryId, @UserMessage String usrMsg);

    @SystemMessage("""
            The execution should be fast with pinpoint accuracy. No scope for errors.
            you are a linkedin assistant. A user has come to you asking help in setting up their linkedin profile.
            you have to first analyze the resume text given to you.
            then you have to make improvements to it. the resume and linkedin profile shouldn't be exactly the same.
            No styling no special characters plain text only no bold no fuss plain text is required.
            after this map your results with improvements and also add your comments in the comments section.
            After everything above is done based on your understanding of the users skill set suggest 2 job roles that closesly match with their resume and experience,
            Only job role no description or reasoning is required no leading or trailing whitespaces.
            Dont add number 1 and 2 just plain simple job role.
            After everything is done now the user wants to get a referral message template to connect to people working in the companies to get job referrals.
            this message should focus on the users skills and sound human written with humility.
            After this you have to generate a referralMessage that will help user to get referrals for this roles keep the company name as [XYZ] as user can edit it accordingly.
            here is the resume : {{usrResume}}
            """)
    LinkedinSections getLinkedinSections(@MemoryId int memoryId, @UserMessage @V("usrResume") String usrResume);

    @SystemMessage("""
            Suggest 2 jobs that closesly match with the users resume and experience.
            Only job role no description or reasoning is required no leading or trailing whitespaces.
            Dont add number 1 and 2 just plain simple job role.
            and map your response accordingly.
            """)
    List<String> getRecommendedJobRole(@MemoryId int memoryId, @UserMessage String usrResume);


}
