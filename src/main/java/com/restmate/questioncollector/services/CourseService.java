package com.restmate.questioncollector.services;

import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.domain.Course;
import com.restmate.questioncollector.domain.Section;
import com.restmate.questioncollector.domain.SectionType;
import com.restmate.questioncollector.domain.json.QuestionJSON;
import com.restmate.questioncollector.repositories.CourseRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CourseService implements CrudService<Course, Long>{

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Set<Course> findAll() {
        Set<Course> courses = new HashSet<>();
        courseRepository.findAll().iterator().forEachRemaining(courses::add);
        return courses;
    }

    public List<Course> findAllBySection(SectionType sectionType){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(course -> {
            Section section = course.getSection();
            if(section != null && section.getSectionType() == sectionType){
                courses.add(course);
            }
        });
        return courses;
    }

    public Set<String> findAllNames(SectionType sectionType){
        Set<String> names = new HashSet<>();
        courseRepository.findAll().iterator().forEachRemaining(course->{
            if(
                    course != null && course.getSection() != null &&
                    course.getSection().getSectionType() == sectionType
            ){
                String name = course.getName();
                names.add(name);
            }
        });
        return names;
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(Category.class, "Course with id " + id + " not found.")
        );
    }

    public Course findByName(String name){
        return courseRepository.findByName(name).orElseThrow(
                () -> new ObjectNotFoundException(Category.class, "Course with name " + name + " not found.")
        );
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
