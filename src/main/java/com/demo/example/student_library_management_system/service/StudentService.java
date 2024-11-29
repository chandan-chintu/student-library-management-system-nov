package com.demo.example.student_library_management_system.service;


import com.demo.example.student_library_management_system.converters.StudentConverter;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    /*
    pagination - fetching the data or records in the form of pages
    pagenumber - the number of page we want to see (page number starts from 0,1,2,3...)
    pagesize - total number of records or data in each page (it is fixed for each page)

    database total records/data - 28, page size -5
    0th page - 1-5
    1st page - 6-10
    2nd page - 11-15
    3rd page - 16-20
    4th page - 21-25
    5th page - 26-28

    database total records - 11, pagesize-2
    0th page - 1-2
    1st page - 3-4
    2nd page - 5-6
    3rd page - 7-8
    4th page - 9-10
    5th page - 11
    sorting - arranging the data or records in ascending or descending order
     */

    public List<Student> getStudentsBasedOnPage(int pageNo, int pageSize, String sortInput){

        // only pagination - Page<Student> studentPage = studentRepository.findAll(PageRequest.of(pageNo,pageSize));
        // pagination and sorting together
        Page<Student> studentPage = studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortInput).ascending()));
        // we cannot send page as output so we need to convert it to list
        List<Student> studentList = studentPage.getContent();
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

    public List<Student> getStudentByDepartment(String department){
        List<Student> studentList = studentRepository.findByDepartment(department);
        return studentList;
    }

    public List<Student> getStudentBySem(String sem){
        List<Student> studentList = studentRepository.getStudentBySem(sem);
        return studentList;
    }
}