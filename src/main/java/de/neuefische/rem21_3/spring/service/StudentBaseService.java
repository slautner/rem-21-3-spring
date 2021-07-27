package de.neuefische.rem21_3.spring.service;

import de.neuefische.rem21_3.spring.model.Student;

import java.util.List;
import java.util.Optional;

public abstract class StudentBaseService implements StudentService {

    @Override
    public Optional<Student> getStudent(String matNumber) {
        List<Student> students = getStudents();
        for (Student student : students) {
            if (student.getMatNumber().equals(matNumber)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Student> updateStudent(String matNumber, Student student) {
        Optional<Student> studentToUpdateOpt = getStudent(matNumber);
        if (studentToUpdateOpt.isEmpty()) {
            return Optional.empty();
        }
        Student studentToUpdate = studentToUpdateOpt.get();

        if (student.getName() != null) {
            studentToUpdate.setName(student.getName());
        }
        if (student.getMatNumber() != null) {
            studentToUpdate.setMatNumber(student.getMatNumber());
        }
        return getStudent(student.getMatNumber());
    }
}
