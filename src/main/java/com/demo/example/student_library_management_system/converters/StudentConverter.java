package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {

    // converters - used to convert the coming input request dto into the model or entity class which directly represents database

    // converts StudentRequestDto into Student class

    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto){
//        Student student = new Student();
//        student.setName(studentRequestDto.getName());
//        student.setEmail(studentRequestDto.getEmail());
//        student.setDob(studentRequestDto.getDob());
//        student.setDepartment(studentRequestDto.getDepartment());
//        student.setSem(studentRequestDto.getSem());
//        student.setGender(studentRequestDto.getGender());
//        return student;

        Student student = Student.builder()
                .name(studentRequestDto.getName())
                .email(studentRequestDto.getEmail())
                .dob(studentRequestDto.getDob())
                .department(studentRequestDto.getDepartment())
                .gender(studentRequestDto.getGender())
                .sem(studentRequestDto.getSem())
                .build();
        return student;
    }
}
