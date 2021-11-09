package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.SectionCommand;
import com.restmate.questioncollector.domain.Section;
import org.springframework.core.convert.converter.Converter;

public class SectionToSectionCommand implements Converter<Section, SectionCommand> {
    @Override
    public SectionCommand convert(Section source) {
        if(source==null) return null;

        final SectionCommand sectionCommand = new SectionCommand();
        sectionCommand.setId(source.getId());
        sectionCommand.setSectionType(source.getSectionType());

        return sectionCommand;
    }
}
