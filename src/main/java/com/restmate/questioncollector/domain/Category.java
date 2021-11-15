package com.restmate.questioncollector.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "categories")
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
    private Set<Question> questions = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    private Set<Course> courses;

    public Category(String description) {
        this.name = description;
    }

    public Category() {
    }

    @Override
    public int compareTo(Category o) {
        return this.name.compareTo(o.getName());
    }
}
