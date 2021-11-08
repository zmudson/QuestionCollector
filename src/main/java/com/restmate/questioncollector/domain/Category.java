package com.restmate.questioncollector.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

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

    public Category(String description) {
        this.name = description;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }
}
