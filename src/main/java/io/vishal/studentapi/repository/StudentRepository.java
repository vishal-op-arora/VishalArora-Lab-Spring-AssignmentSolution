package io.vishal.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.vishal.studentapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>   {

}
