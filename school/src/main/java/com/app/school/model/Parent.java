package com.app.school.model;

import com.app.school.enums.Gender;
import com.app.school.enums.Relation;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "parents")
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

    @ManyToMany(mappedBy = "parents")
    private Set<Student> students;
}
