package com.restmate.questioncollector.domain.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionJSON {
    private String description;
    private String answer;
    private String course;
    private String category;
    private String section;
}
