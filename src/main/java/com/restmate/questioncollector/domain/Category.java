package com.restmate.questioncollector.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "categories")
@JsonIgnoreProperties(value = { "questions", "courses" })
public class Category extends BaseEntity implements Comparable<Category>{

    @Column(
            name = "name",
            unique = true
    )
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "category"
    )
    @JsonIgnoreProperties("category")
    private Set<Question> questions = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    private Set<Course> courses = new HashSet<>();

    public Category(String description) {
        this.name = description;
    }

    public Category() {
    }

    @Override
    public int compareTo(Category o) {
        return this.name.compareTo(o.getName());
    }

    public void addQuestion(Question question) {
        if(question != null){
            questions.add(question);
            if(question.getCategory() != null){
                question.setCategory(this);
            }
        }
    }

    public void addCourse(Course course){
        courses.add(course);
        course.getCategories().add(this);
    }
}
