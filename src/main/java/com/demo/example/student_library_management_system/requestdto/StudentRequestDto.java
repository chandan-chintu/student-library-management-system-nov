package com.demo.example.student_library_management_system.requestdto;

import lombok.Data;

@Data
public class StudentRequestDto {

    // dto - data transfer object ( it is used to take the request input fields)

    private String name;
    private String dob;
    private String gender;
    private String email;
    private String department;
    private String sem;
}
