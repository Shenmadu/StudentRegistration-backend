package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Data
@ToString
@AllArgsConstructor
public class Course {

    private String description;
    private String code;
    private String fee;
    private String duration;
    private String institute;

}
