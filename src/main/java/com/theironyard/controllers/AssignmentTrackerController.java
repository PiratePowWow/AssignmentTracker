package com.theironyard.controllers;

import com.theironyard.entities.Assignment;
import com.theironyard.entities.Student;
import com.theironyard.services.AssignmentRepository;
//import com.theironyard.services.StudentAssignmentRepository;
import com.theironyard.services.StudentRepository;
import com.theironyard.utils.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;

/**
 * Created by PiratePowWow on 3/10/16.
 */
@Controller
public class AssignmentTrackerController {
    @Autowired
    StudentRepository students;
    @Autowired
    AssignmentRepository assignments;
//    @Autowired
//    StudentAssignmentRepository studentAssignments;
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
    public String home(Model model, HttpSession session){
        UUID id = (UUID) session.getAttribute("student");
        if(id!=null) {
            Student student = students.findOne(id);
            List<Assignment> completed = student.getAssignments();
            Collections.sort(completed);
            ArrayList<Assignment> openAssignments = new ArrayList<Assignment>();
            for(Assignment eachAssignment: assignments.findAllByOrderByNumAsc()){
                boolean complete = false;
                for(Assignment completedAssignment: completed){
                    if (completedAssignment.getNum()==eachAssignment.getNum()){
                        complete = true;
                    }
                }
                if (!complete){
                    openAssignments.add(eachAssignment);
                }
            }
            model.addAttribute("assignments", openAssignments);
            model.addAttribute("completed", completed);
            model.addAttribute("student", student);
        }else{
            model.addAttribute("assignments", assignments.findAllByOrderByNumAsc());
            model.addAttribute("students", students.findAllByOrderByNameAsc());
        }
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String name, String password) throws Exception {
        if(!PasswordStorage.verifyPassword(password, students.findStudentByName(name).getPasswordHash())){
            throw new Exception("Incorrect Password");
        }
        session.setAttribute("student", students.findStudentByName(name).getId());
        return "redirect:/";
    }
    @RequestMapping(path = "/change-password", method = RequestMethod.POST)
    public String changePassword(HttpSession session){
        return "redirect:/";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping(path = "/add-assignment", method = RequestMethod.POST)
    public String addAssignment(HttpSession session, String assignmentId){
        Student student = students.findOne((UUID) session.getAttribute("student"));
        student.getAssignments().add(assignments.findOne(UUID.fromString(assignmentId)));
        students.save(student);
        return "redirect:/";
    }
    @RequestMapping(path = "/remove-assignment", method = RequestMethod.POST)
    public String removeAssignment(HttpSession session, String assignmentId){
        Student student = students.findOne((UUID) session.getAttribute("student"));
        student.getAssignments().remove(assignments.findOne(UUID.fromString(assignmentId)));
        students.save(student);
        return "redirect:/";
    }
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(HttpSession session){
        return "redirect:/";
    }
}
