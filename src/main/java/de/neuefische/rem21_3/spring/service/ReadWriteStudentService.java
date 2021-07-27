package de.neuefische.rem21_3.spring.service;

import de.neuefische.rem21_3.spring.model.Student;
import de.neuefische.rem21_3.spring.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("readWrite")
public class ReadWriteStudentService extends StudentBaseService implements StudentService {

    private StudentRepository studentRepository;
    private MatNumberService matNumberService;

    @Autowired
    public ReadWriteStudentService(StudentRepository studentRepository, MatNumberService matNumberService) {
        this.studentRepository = studentRepository;
        this.matNumberService = matNumberService;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        String generatedMatNumber = matNumberService.generateId();
        student.setMatNumber(generatedMatNumber);

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
