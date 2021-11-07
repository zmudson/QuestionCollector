package com.restmate.questioncollector.commands;

import com.restmate.questioncollector.domain.SectionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SectionCommand {
    private Long id;
    private SectionType sectionType;
}
