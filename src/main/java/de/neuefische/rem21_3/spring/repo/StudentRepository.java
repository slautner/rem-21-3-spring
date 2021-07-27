package de.neuefische.rem21_3.spring.repo;

import de.neuefische.rem21_3.spring.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.addAll(
                List.of(
                        new Student("Martin", "5"),
                        new Student("Florian", "10")
                )
        );
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> get(String matNumber) {
        for (Student student : students) {
            if (student.getMatNumber().equals(matNumber)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public void add(Student student) {
        students.add(student);
    }

    public void delete(Student student) {
        students.remove(student);
    }
}
