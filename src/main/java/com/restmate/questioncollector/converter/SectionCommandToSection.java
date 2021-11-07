package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.SectionCommand;
import com.restmate.questioncollector.domain.Section;
import org.springframework.core.convert.converter.Converter;

public class SectionCommandToSection implements Converter<SectionCommand, Section> {
    @Override
    public Section convert(SectionCommand source) {
        if(source==null) return null;

        final Section section = new Section();
        section.setId(source.getId());
        section.setSectionType(source.getSectionType());

        return section;
    }
}
