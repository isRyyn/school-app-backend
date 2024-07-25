package com.app.school.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private Set<Long> standardIds = new HashSet<>();


    @ElementCollection
    private Set<Long> marksIds = new HashSet<>();

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getStandardIds() {
        return standardIds;
    }

    public void setStandardIds(Set<Long> standardIds) {
        this.standardIds = standardIds;
    }
}
