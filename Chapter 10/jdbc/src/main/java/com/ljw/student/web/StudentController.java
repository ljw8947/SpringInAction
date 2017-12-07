package com.ljw.student.web;

import com.ljw.student.dao.StudentRepository;
import com.ljw.student.domain.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwlv on 2017/12/6.
 */
@Controller
public class StudentController {

    private static StudentRepository sr;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.sr=studentRepository;
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
        for(int i=0;i<10;i++ ){
            studentInfoList.add(new StudentInfo());
        }
        studentInfoList =sr.findAll();
        model.addAttribute("studentList", studentInfoList);
        return "students";
    }

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable Long id,Model model){
        StudentInfo s=new StudentInfo();
        s=sr.findByID(id);
        model.addAttribute("student",s);
        return "student";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model){
        model.addAttribute("student",new StudentInfo());

        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(StudentInfo studentInfo){
        StudentInfo s=sr.save(studentInfo);
        return "redirect:/student/"+s.getStudentID();
    }


}
