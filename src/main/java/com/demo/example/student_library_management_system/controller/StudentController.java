package com.demo.example.student_library_management_system.controller;

import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import com.demo.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.addStudent(studentRequestDto);
        return response;
    }

    @GetMapping("/find/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }
}
