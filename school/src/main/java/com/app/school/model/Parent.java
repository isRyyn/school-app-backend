package com.app.school.model;

import com.app.school.enums.Gender;
import com.app.school.enums.Relation;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private Integer mobile;
    private Gender gender;
    private Relation relation;

    @ElementCollection
    private Set<Long> childIds = new HashSet<>();
}
