package io.vishal.studentapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.vishal.studentapi.model.Student;
import io.vishal.studentapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	
	@Transactional
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Transactional
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	@Transactional
	public Student findById(long id) {
		return studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No student found."));
	}

	@Transactional
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}
	
	@Transactional
	public Student updateStudent(Student student, long studentId) {
		
		Student newStudent;
		
		if(studentRepository.findById(studentId).isPresent()) {
			newStudent = studentRepository.getById(studentId);
			newStudent.setFirstName(student.getFirstName());
			newStudent.setLastName(student.getLastName());
			newStudent.setCourse(student.getCourse());
			newStudent.setCountry(student.getCountry());
		}
		else {
			newStudent = student;
		}		
		
		return studentRepository.save(newStudent);
	}
}
