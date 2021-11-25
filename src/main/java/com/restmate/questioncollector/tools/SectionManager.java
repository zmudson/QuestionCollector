package com.restmate.questioncollector.tools;

import com.restmate.questioncollector.domain.SectionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

public class SectionManager {
    public static SectionType getSection(String section) throws ResponseStatusException{
        section = section.toLowerCase(Locale.ROOT);
        SectionType sectionType;

        if ("frontend".equals(section)) {
            sectionType = SectionType.FRONTEND;
        }else if("backend".equals(section)){
            sectionType = SectionType.BACKEND;
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no \"" + section + "\" section");
        }
        return sectionType;
    }
}
