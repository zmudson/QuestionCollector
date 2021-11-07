package com.restmate.questioncollector.commands;

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

    //TODO add all fields


    @Override
    public String toString() {
        return "QuestionCommand{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
