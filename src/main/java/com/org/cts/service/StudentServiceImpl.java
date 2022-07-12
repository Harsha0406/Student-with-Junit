package com.org.cts.service;

import com.org.cts.model.Student;
import com.org.cts.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepo studentRepo;

    @Override
    public void createStudent(Student student) {
        studentRepo.save(student);

    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.save(student);

    }

    @Override
    public List<Student> getAll() {
        List<Student>ss=studentRepo.findAll();
        return ss;
    }

    @Override
    public Optional<Student> getById(Integer id) {
        Optional<Student> aa = studentRepo.findById(id);
        return aa;
    }

    @Override
    public String deleteById(Integer id) {
        studentRepo.deleteById(id);
        return "success";
    }
}
