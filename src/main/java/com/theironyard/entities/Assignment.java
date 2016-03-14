package com.theironyard.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

/**
 * Created by PiratePowWow on 3/10/16.
 */
@Entity
public class Assignment implements Comparable{
    @Id
    @Type(type="uuid-char")
    private UUID id;
    @NotNull
    @Column(unique = true)
    private double num;
    @NotNull
    private String name;
//    @ManyToMany
//    Set<Student> students;

    public Assignment(UUID id, double num, String name) {
        this.id = id;
        this.num = num;
        this.name = name;
    }

//    public Set<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }

    public Assignment() {
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

    @Override
    public int compareTo(Object o) {
        Assignment a = (Assignment) o;
        if(num == a.num){
            return 0;
        }else if(num < a.num){
            return -1;
        }else{
            return 1;
        }
    }
}
