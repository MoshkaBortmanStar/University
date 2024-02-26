package org.example.university.service.impl;


import org.example.university.data.Student;
import org.example.university.data.dto.StudentDto;
import org.example.university.service.StudentConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


@Service
public class SpecificStudConvertor implements StudentConverter {
    public Student convertToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setSecondName(studentDto.getSecondName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(studentDto.getDateOfBirth(), formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        student.setAge(period.getYears());
        return student;
    }
}
