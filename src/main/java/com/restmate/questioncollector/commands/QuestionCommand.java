package com.restmate.questioncollector.commands;

import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.domain.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionCommand {
    private Long id;
    private String description;
    private String answer;
    private String course;
    private String category;


    @Override
    public String toString() {
        return "QuestionCommand{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", answer='" + answer + '\'' +
                ", course=" + course +
                ", category='" + category + '\'' +
                '}';
    }
}
