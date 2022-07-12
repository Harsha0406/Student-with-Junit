package com.org.cts.service;

import com.org.cts.model.Student;
import com.org.cts.repository.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceImplTest {
    @InjectMocks
    private StudentServiceImpl StudentServiceImpl;
    @Mock
    private StudentRepo studentRepo;

    @Test
    void testCreateStudent() {
        Student student=new Student();
        student.setId(100);
        student.setName("sai");
        student.setAddress("blr");
        student.setFees(12345);
        StudentServiceImpl.createStudent(student);
        Mockito.verify(studentRepo,Mockito.times(1)).save(student);
    }

    @Test
    void testUpdateStudent() {
        Student student=new Student();
        student.setId(100);
        student.setName("sai");
        student.setAddress("blr");
        student.setFees(12345);
        StudentServiceImpl.updateStudent(student);
        Mockito.verify(studentRepo,Mockito.times(1)).save(student);
    }

    @Test
    void testGetAll() {
        List<Student> list=new ArrayList<>();
        Student student=new Student();
        student.setId(100);
        student.setName("sai");
        student.setAddress("blr");
        student.setFees(12345);
        list.add(student);
        Student student1=new Student();
        student1.setId(101);
        student1.setName("sai");
        student1.setAddress("blr");
        student1.setFees(12345);
        list.add(student1);
        Mockito.when(studentRepo.findAll()).thenReturn(list);
        List<Student> list2=  StudentServiceImpl.getAll();
        Assertions.assertEquals(list,list2);
    }

    @Test
    void getById() {
        int id=100;
        Student student=new Student();
        student.setId(100);
        student.setName("sai");
        student.setAddress("blr");
        student.setFees(12345);
        Optional<Student> student1=Optional.of(student);
        Mockito.when(studentRepo.findById(id)).thenReturn(student1);
        Optional<Student> Student2=   StudentServiceImpl.getById(id);
        Assertions.assertEquals(student1.get().getId(),Student2.get().getId());
    }

    @Test
    void deleteById() {
        int id=100;
        String value="success";
        String value2= StudentServiceImpl.deleteById(id);
        Mockito.verify(studentRepo,Mockito.times(1)).deleteById(id);
        Assertions.assertEquals(value,value2);
    }
}