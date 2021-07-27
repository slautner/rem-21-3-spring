package de.neuefische.rem21_3.spring.service;

import de.neuefische.rem21_3.spring.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


public abstract class StudentBaseService implements StudentService {

    @Override
    public Student getStudent(String matNumber) {
        List<Student> students = getStudents();
        for (Student student : students) {
            if (student.getMatNumber().equals(matNumber)) {
                return student;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public Student updateStudent(String matNumber, Student student) {
        Student studentToUpdate = getStudent(matNumber);

        if (student.getName() != null) {
            studentToUpdate.setName(student.getName());
        }
        if (student.getMatNumber() != null) {
            studentToUpdate.setMatNumber(student.getMatNumber());
        }
        return getStudent(student.getMatNumber());
    }
}
