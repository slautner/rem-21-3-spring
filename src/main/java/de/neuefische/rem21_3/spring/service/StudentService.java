package de.neuefische.rem21_3.spring.service;


import de.neuefische.rem21_3.spring.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudent(String matNumber);

    Student updateStudent(String matNumber, Student student);
}
