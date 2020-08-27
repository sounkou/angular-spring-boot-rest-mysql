package com.gainde2000.springbootmysqlrestapi.service;

import com.gainde2000.springbootmysqlrestapi.entity.Student;
import com.gainde2000.springbootmysqlrestapi.exception.ResourceNotFoundException;
import com.gainde2000.springbootmysqlrestapi.repository.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    StudentRepos studentRepos;

    //Method to save student data into database
    public Student saveStudent(Student student) {
        return studentRepos.save(student);
    }


    //to get all the student details from database
    public List<Student> getAllStudent() {
       return studentRepos.findAll();
    }

    public Student updateStudentDetails(Long id, Student student){
       Student studentDetails = studentRepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student non trouver avec ", "id", id));
       
       return studentRepos.save(student);
    }

    public void deleteStudent(Student student){
        studentRepos.delete(student);
    }
 
    public Optional<Student> getStudentById(Long Id){
        return studentRepos.findById(Id);
    }






}




