package com.example.studentcrud.controller;

import com.example.studentcrud.entity.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        @NotBlank @Size(max = 255) String name,
        @NotBlank @Email @Size(max = 255) String email,
        @NotBlank @Size(max = 255) String course) {
    Student toStudent() {
        return new Student(null, name.trim(), email.trim(), course.trim());
    }
}
