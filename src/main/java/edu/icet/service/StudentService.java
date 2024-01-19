package edu.icet.service;

import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    StudentEntity createStudent(Student student);

    List<Student> retriveStudent();
    public boolean removeStudent(long studentId);
}
