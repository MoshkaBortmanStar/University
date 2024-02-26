package org.example.university.service;

import org.example.university.data.Student;
import org.example.university.data.dto.StudentDto;

public interface StudentConverter {
    Student convertToStudent(StudentDto studentDto);
}
