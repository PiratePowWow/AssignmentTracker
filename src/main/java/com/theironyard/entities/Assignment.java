package com.theironyard.entities;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by PiratePowWow on 3/10/16.
 */
@Entity
public class Assignment {
    @Id
    @Type(type="uuid-char")
    private UUID id;
    @NotNull
    private double num;
    @NotNull
    private String name;
    @NotNull
    private boolean isComplete;
    @ManyToOne
    private Student student;

    public Assignment(UUID id, double num, String name, boolean isComplete, Student student) {
        this.id = id;
        this.num = num;
        this.name = name;
        this.isComplete = isComplete;
        this.student = student;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
