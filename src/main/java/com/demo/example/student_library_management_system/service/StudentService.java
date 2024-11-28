package com.demo.example.student_library_management_system.service;


import com.demo.example.student_library_management_system.converters.StudentConverter;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        Student student = StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

        //whenever the student gets added card also issued to that student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);
        return "Student and card Saved Successfully";
    }

    public Student getStudentById(int studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.get();
        return student;
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public long countStudents(){
        long count = studentRepository.count();
        return count;
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "student deleted";
    }

    public String updateStudent(int studentId, StudentRequestDto newStudentRequestDto){
        // first take studentId and find student details
        // if student present update it
        // else no need
        Student student = getStudentById(studentId);
        if(student!=null){
            student.setName(newStudentRequestDto.getName());
            student.setGender(newStudentRequestDto.getGender());
            student.setSem(newStudentRequestDto.getSem());
            student.setDob(newStudentRequestDto.getDob());
            student.setEmail(newStudentRequestDto.getEmail());
            student.setDepartment(newStudentRequestDto.getDepartment());
            studentRepository.save(student);
            return "student updated successfully";
        } else {
            return "Cannot find student to update";
        }
    }
}