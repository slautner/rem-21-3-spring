package de.neuefische.rem21_3.spring.service;


import de.neuefische.rem21_3.spring.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("default")
public class DefaultStudentService extends StudentBaseService implements StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student("Klaus", "1A"),
                new Student("Tina", "2B")
        );
    }

    @Override
    public Student createStudent(Student student) {
        throw new UnsupportedOperationException("Unable to create new Students");
    }

    @Override
    public Optional<Student> deleteStudent(String matNumber) {
        throw new UnsupportedOperationException("Unable to delete Students");
    }
}
