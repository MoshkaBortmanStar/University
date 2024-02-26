package org.example.university.service.impl;


import org.example.university.data.Student;
import org.example.university.service.UniService;
import org.example.university.service.cashService.StudentsMap;
import org.springframework.stereotype.Service;


@Service
public class Uni implements UniService {
    StudentsMap studentsMap = StudentsMap.GET_INSTANCE();
    @Override
    public void study() {
        for (Integer i : StudentsMap.getStudentsMap().keySet()) {
            Student student = StudentsMap.getStudentsMap().get(i);
            System.out.println(student.getName() + " is studying. It is " + student.getAge());
            student.setAge(student.getAge() + 1);
        }
        System.out.println("The end of the year of study");
        studentsMap.showStudents();
        System.out.println(studentsMap.countStudents() + " students has ended a year");
    }
}
