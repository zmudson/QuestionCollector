package com.restmate.questioncollector.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
@JsonIgnoreProperties(value = { "section", "questions", "categories" })
public class Course extends BaseEntity  implements Comparable<Course>{

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
//    @JsonIgnoreProperties("courses")
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private Section section;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "course"
    )
    @JsonIgnoreProperties("course")
    private Set<Question> questions = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "courses_categories",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id")
            }
    )
    @JsonIgnoreProperties("courses")
    private Set<Category> categories = new HashSet<>();

    public Course(String name, Section section) {
        this.name = name;
        this.section = section;
    }

    public Course() {
    }

    public void addQuestion(Question question) {
        if(question != null){
            questions.add(question);
            if(question.getCourse() != null){
                question.setCourse(this);
            }
        }
    }

    public void addCategory(Category category){
        categories.add(category);
        category.getCourses().add(this);
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.getName());
    }
}
