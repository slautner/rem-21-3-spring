package de.neuefische.rem21_3.spring.service;

import de.neuefische.rem21_3.spring.model.Student;
import de.neuefische.rem21_3.spring.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("readWrite")
public class ReadWriteStudentService extends StudentBaseService implements StudentService {

    //    @Resource
    private StudentRepository studentRepository;

    @Autowired
    public ReadWriteStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        student.setMatNumber(UUID.randomUUID().toString());
        studentRepository.add(student);

        return student;
    }

    @Override
    public Optional<Student> deleteStudent(String matNumber) {
        Optional<Student> studentOpt = studentRepository.get(matNumber);
        if (studentOpt.isPresent()) {
            studentRepository.delete(studentOpt.get());
        }
        return studentOpt;
    }
}
