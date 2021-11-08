package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.CategoryCommand;
import com.restmate.questioncollector.domain.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Override
    public CategoryCommand convert(Category source) {
        if(source==null) return null;

        final CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getName());


        return categoryCommand;
    }
}
