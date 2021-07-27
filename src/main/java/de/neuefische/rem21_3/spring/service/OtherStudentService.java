package de.neuefische.rem21_3.spring.service;

import de.neuefische.rem21_3.spring.model.Student;
import de.neuefische.rem21_3.spring.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("other")
public class OtherStudentService extends StudentBaseService implements StudentService {

//    @Resource
    private StudentRepository studentRepository;

    @Autowired
    public OtherStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
