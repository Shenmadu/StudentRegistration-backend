package edu.icet.service;

import edu.icet.dto.Student;
import edu.icet.dto.responce.DogResponce;
import edu.icet.entity.StudentEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StudentService {

    StudentEntity createStudent(Student student);

    List<Student> retriveStudent();
    public boolean removeStudent(long studentId);
    ResponseEntity<DogResponce> getInformation();
}
