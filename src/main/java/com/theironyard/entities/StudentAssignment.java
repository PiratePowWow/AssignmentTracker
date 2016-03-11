//package com.theironyard.entities;
//
//import org.hibernate.annotations.Type;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Set;
//import java.util.UUID;
//
///**
// * Created by PiratePowWow on 3/10/16.
// */
////@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"student_id" , "assignment_id"})})
////@Entity
//public class StudentAssignment {
////    @Id
////    @Type(type="uuid-char")
////    private UUID id;
////    @NotNull
////    @ManyToOne
////    private Student student;
////    @NotNull
////    @ManyToOne
////    private Assignment assignment;
//
////    public StudentAssignment(UUID id, Student student, Assignment assignment) {
////        this.id = id;
////        this.student = student;
////        this.assignment = assignment;
////    }
////
////    public UUID getId() {
////        return id;
////    }
////
////    public void setId(UUID id) {
////        this.id = id;
////    }
////    public StudentAssignment(){
////
////    }
////
////    public Student getStudent() {
////        return student;
////    }
////
////    public void setStudent(Student student) {
////        this.student = student;
////    }
////
////    public Assignment getAssignment() {
////        return assignment;
////    }
////
////    public void setAssignment(Assignment assignment) {
////        this.assignment = assignment;
////    }
//}
