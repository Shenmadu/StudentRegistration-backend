package edu.icet.controller;


import edu.icet.dto.Course;
import edu.icet.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses/list")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }




}
