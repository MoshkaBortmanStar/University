package org.example.university.service.cashService;


import org.example.university.data.Student;

public interface StudentsCash {
    void addStudent(Student student);
    int countStudents();
    void showStudents();
}
