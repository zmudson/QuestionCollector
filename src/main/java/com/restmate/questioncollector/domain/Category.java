package com.restmate.questioncollector.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(name = "description")
    private String description;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "category"
    )
    private Set<Question> questions = new HashSet<>();

    public Category(String description) {
        this.description = description;
    }

    public Category() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
