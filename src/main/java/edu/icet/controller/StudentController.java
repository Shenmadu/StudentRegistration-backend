package edu.icet.controller;


import edu.icet.common.AuditTime;
import edu.icet.dto.Response;
import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j

public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/student")
    StudentEntity createStudent(@RequestBody Student student){
        return service.createStudent(student);
    }
    @PatchMapping("/student")
    StudentEntity updateStudent(@RequestBody Student student){
        return service.createStudent(student);
    }


    @GetMapping("/student")
    @AuditTime
    List<Student> getStudent() {
        return service.retriveStudent();
    }

    @DeleteMapping("/student/{studentId}")
    Response removeStudent(@PathVariable Long studentId){

        return service.removeStudent(studentId) ?
                new Response("Student Removed"):
                new Response("Student not Exists");
    }

}
