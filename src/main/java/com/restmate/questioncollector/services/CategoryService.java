package com.restmate.questioncollector.services;

import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.repositories.CategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryService implements CrudService<Category, Long> {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> findAll() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories;
    }

    public Category findByName(String name){
        return categoryRepository.findByName(name).orElseThrow(
                () -> new ObjectNotFoundException(Category.class, "Category with name " + name + " not found.")
        );
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(Category.class, "Category with id " + id + " not found.")
        );
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
