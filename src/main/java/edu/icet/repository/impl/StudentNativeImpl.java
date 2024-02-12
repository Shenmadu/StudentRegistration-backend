package edu.icet.repository.impl;

import edu.icet.repository.StudentNativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;

@Repository
public class StudentNativeImpl implements StudentNativeRepository {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public boolean removeStudent(Long studentId){
        return namedParameterJdbcTemplate.update(
                "DELETE FROM WHERE ID=:id",
                Collections.singletonMap("id", studentId))>0;


    }

}
