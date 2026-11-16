package com.example.studentcrud.service;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ BY ID
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {

        Student existing = getStudentById(id);

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());

        return repository.save(existing);
    }

    // DELETE
    public void deleteStudent(Long id) {
        Student existing = getStudentById(id);
        repository.delete(existing);
    }
}