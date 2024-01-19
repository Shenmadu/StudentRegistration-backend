package edu.icet.controller;


import edu.icet.dto.Response;
import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController

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
    List<Student> getStudent() {
        return service.retriveStudent();
    }

    @DeleteMapping("/student/{studentId}")
    Response removeStudent(@PathVariable Long studentId){

        return service.removeStudent(studentId) ?
                new Response("Student Removed"):
                new Response("Student not Exists");
    }
//    Map removeStudent(@PathVariable Long studentId){ //send one parameter, if this have 20 parameter can use Request body
//       return service.removeStudent(studentId)?
//        Collections.singletonMap("status","removed student"):
//        Collections.singletonMap("status","Student ID Invalid");//return as Json Object for human readable easy
//
//    }

//---------------Second method delete api-----------

//    @DeleteMapping("student/{studentId}")
//    Response removeStudent(@PathVariable Long studentId){ //send one parameter, if this have 20 parameter can use Request body
//        boolean isRemoved = service.removeStudent(studentId);
//
//        if(isRemoved){
//            return Response("status","removed student");
//        }else{
//            return Response(String.format("Student Id(%$) Invalid",studentId))"
//        }
//
//
//    }
}
