package com.gainde2000.springbootmysqlrestapi.repository;

import com.gainde2000.springbootmysqlrestapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepos extends JpaRepository<Student, Long> {
} 
