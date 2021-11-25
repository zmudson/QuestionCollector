package com.restmate.questioncollector.commands;

import com.restmate.questioncollector.services.CrudService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

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
        return !(
                description == null || description.isEmpty() ||
                answer == null || answer.isEmpty() ||
                course == null || course.isEmpty() ||
                category == null || category.isEmpty()
        );
    }

    @Override
    public String toString() {
        return "QuestionCommand{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", answer='" + answer + '\'' +
                ", course='" + course + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
