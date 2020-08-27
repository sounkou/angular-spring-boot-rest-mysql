package com.gainde2000.springbootmysqlrestapi.controller;

import com.gainde2000.springbootmysqlrestapi.entity.Student;
import com.gainde2000.springbootmysqlrestapi.exception.ResourceNotFoundException;
import com.gainde2000.springbootmysqlrestapi.repository.StudentRepos;
import com.gainde2000.springbootmysqlrestapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {


    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepos studentRepos;

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/student")
    public Student saveStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable(value = "id") Long studentId) {
        return studentService.getStudentById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable(value = "id") Long studentId,
                           @Valid @RequestBody Student student) {
        Student studentDetails = studentService.getStudentById(studentId).get();
        studentDetails.setFirstName(student.getFirstName());
        studentDetails.setLastName(student.getLastName());
        studentDetails.setEmail(student.getEmail());
        studentDetails.setBranch(student.getBranch());
        return studentService.updateStudentDetails(studentId,studentDetails);
    }


    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentService.getStudentById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Studentnon trouvé avec  ", "id", studentId));
        studentRepos.delete(student);
        return ResponseEntity.ok().build();
    }
}
