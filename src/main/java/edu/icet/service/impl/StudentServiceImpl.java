package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Student;
import edu.icet.dto.responce.DogResponce;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentNativeRepository;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentNativeRepository studentNativeRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    RestTemplate restTemplate;


    public StudentEntity createStudent(Student student){

        //Model to Entity Conversion
        StudentEntity entity =
                mapper.convertValue(student, StudentEntity.class);

        //Saving Data
        return studentRepository.save(entity);

    }

    @Override
    public List<Student> retriveStudent() {

        List<Student> list = new ArrayList<>();

        Iterable<StudentEntity> studentList = studentRepository.findAll();//SELECT * from Student (findAll)

        Iterator<StudentEntity> iterator = studentList.iterator();

        while(iterator.hasNext()){
            StudentEntity entity = iterator.next(); //get next variable
            Student student = mapper.convertValue(entity, Student.class);//convert using model mapper entity to dto
            list.add(student);
        }

        return list;
    }
    public boolean removeStudent(long studentId){

        Optional<StudentEntity> studentEntityoptional=studentRepository.findById(studentId); //null type safe

        if(studentEntityoptional.isPresent()){
//            StudentEntity entity = studentEntityoptional.get(); //get the student object Optional bag eken
            studentRepository.deleteById(studentId);
            return true;

        }
        return false;
//        return studentNativeRepository.removeStudent(studentId); custom quory

    }
    public ResponseEntity<DogResponce> getInformation(){
        ResponseEntity<DogResponce> exchange = this.restTemplate.exchange(
                "https://dog.ceo/api/breeds/image/random",
                HttpMethod.GET, null, DogResponce.class
        );

        return exchange;
    }

}
