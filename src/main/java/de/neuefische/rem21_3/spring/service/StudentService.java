package de.neuefische.rem21_3.spring.service;


import de.neuefische.rem21_3.spring.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getStudents();

    Optional<Student> getStudent(String matNumber);

    Optional<Student> updateStudent(String matNumber, Student student);
}
