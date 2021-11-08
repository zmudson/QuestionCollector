package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.CategoryCommand;
import com.restmate.questioncollector.domain.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Override
    public Category convert(CategoryCommand source) {
        if(source==null) return null;
        final Category category = new Category();
        category.setId(source.getId());
        category.setName(source.getDescription());


        return category;
    }
}
