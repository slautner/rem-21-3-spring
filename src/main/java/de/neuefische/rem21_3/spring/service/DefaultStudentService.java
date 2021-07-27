package de.neuefische.rem21_3.spring.service;


import de.neuefische.rem21_3.spring.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("default")
public class DefaultStudentService extends StudentBaseService implements StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student("Klaus", "1A"),
                new Student("Tina", "2B")
        );
    }
}
