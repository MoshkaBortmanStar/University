package org.example.university.controller;


import lombok.RequiredArgsConstructor;
import org.example.university.data.Student;
import org.example.university.data.dto.StudentDto;
import org.example.university.service.StudentConverter;
import org.example.university.service.UniService;
import org.example.university.service.cashService.StudentsMap;
import org.example.university.service.impl.Uni;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class UniController {

    private final UniService uniService;
    private final StudentConverter studentConverter;


    StudentsMap studentsMap = StudentsMap.GET_INSTANCE();


    @GetMapping("/get")
    public void study() {

        StudentsMap studentsMap = StudentsMap.GET_INSTANCE();
        studentsMap.addStudent(new Student("Alex", "A", 20));
        studentsMap.addStudent(new Student("Ben", "B", 23));
        studentsMap.addStudent(new Student("Clark", "C", 25));


        uniService.study();
    }


    @PutMapping("/add")
    public Student addStudent(@RequestBody StudentDto studentDto) {
        Student student = studentConverter.convertToStudent(studentDto);
        System.out.println(student);
        studentsMap.addStudent(student);

        return student;
    }



}
