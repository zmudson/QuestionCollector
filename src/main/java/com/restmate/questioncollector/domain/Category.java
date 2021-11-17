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
}
