package com.theironyard.controllers;

import com.theironyard.entities.Assignment;
import com.theironyard.entities.Student;
import com.theironyard.services.AssignmentRepository;
import com.theironyard.services.StudentAssignmentRepository;
import com.theironyard.services.StudentRepository;
import com.theironyard.utils.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by PiratePowWow on 3/10/16.
 */
@Controller
public class AssignmentTrackerController {
    @Autowired
    StudentRepository students;
    @Autowired
    AssignmentRepository assignments;
    @Autowired
    StudentAssignmentRepository studentAssignments;
//    @PostConstruct
//    public void populateDatabase() throws FileNotFoundException, PasswordStorage.CannotPerformOperationException {
//        File c = new File("students.csv");
//        Scanner s = new Scanner(c);
//        while(s.hasNext()){
//            String a = s.nextLine();
//            students.save(new Student(java.util.UUID.randomUUID(), a, PasswordStorage.createHash("tracker")));
//        }
//        File p = new File("assignments.csv");
//        Scanner pur = new Scanner(p);
//        while(pur.hasNext()){
//            String[] pr = pur.nextLine().split(",");
//                assignments.save(new Assignment(java.util.UUID.randomUUID(), Double.valueOf(pr[0]), pr[1]));
//        }
//    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(){
        return "redirect:/";
    }
    @RequestMapping(path = "/change-password", method = RequestMethod.POST)
    public String changePassword(){
        return "redirect:/";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(){
        return "redirect:/";
    }
    @RequestMapping(path = "/add-assignment", method = RequestMethod.POST)
    public String addAssignment(){
        return "redirect:/";
    }
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(){
        return "redirect:/";
    }
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(){
        return "redirect:/";
    }
}
