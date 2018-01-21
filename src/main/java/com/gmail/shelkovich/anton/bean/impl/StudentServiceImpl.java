package com.gmail.shelkovich.anton.bean.impl;

import com.gmail.shelkovich.anton.model.Student;
import com.gmail.shelkovich.anton.bean.StudentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student st = new Student();
            st.setName("Name"+i);
            students.add(st);
        }
        return students;
    }
}
