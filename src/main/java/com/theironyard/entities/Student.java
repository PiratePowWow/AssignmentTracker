package com.theironyard.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by PiratePowWow on 3/10/16.
 */
@Entity
public class Student {
    @Id
    @Type(type="uuid-char")
    private UUID id;
    @Column(unique = true, nullable = false)
    private String name;
    @NotNull
    private String passwordHash;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Assignment> assignments;

    public Student(UUID id, String name, String passwordHash) {
        this.id = id;
        this.name = name;
        this.passwordHash = passwordHash;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Student() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
