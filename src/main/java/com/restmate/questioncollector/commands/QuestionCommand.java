package com.restmate.questioncollector.commands;

import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.domain.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionCommand {
    private Long id;
    @Lob
    private String description;
    @Lob
    private String answer;
    private String course;
    private String category;

    public boolean isValid() {
        return !(description.isEmpty() || answer.isEmpty() || course.isEmpty() || category.isEmpty());
    }
}
