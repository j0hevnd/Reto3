package com.gym.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="library")
public class Library implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer librariesId;
    private String name;
    private String target;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("libraries")
    private Category category;

    public Integer getId() {
        return librariesId;
    }

    public void setId(Integer librariesId) {
        this.librariesId = librariesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
