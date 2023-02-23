package com.tmportfolio.recipeapp.model;

import jakarta.persistence.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String description() {
        return description;
    }

    public void setUom(String description) {
        this.description = description;
    }
}