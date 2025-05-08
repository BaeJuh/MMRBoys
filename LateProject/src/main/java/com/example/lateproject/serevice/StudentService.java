package com.example.lateproject.serevice;

import com.example.lateproject.entity.LateHistory;
import com.example.lateproject.entity.Student;
import com.example.lateproject.model.StudentCreateRequest;
import com.example.lateproject.model.StudentItem;
import com.example.lateproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void setStudent(StudentCreateRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setPhoneNumber(request.getPhoneNumber());

        studentRepository.save(student);
    }

    public List<StudentItem> getStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentItem> studentItems = new ArrayList<>();

        students.forEach(student -> {
            StudentItem newStudent = new StudentItem();
           newStudent.setId(student.getId());
           newStudent.setName(student.getName());
           newStudent.setPhoneNumber(student.getPhoneNumber());

           studentItems.add(newStudent);
        });

        return studentItems;
    }

    public StudentItem getStudent(long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        StudentItem studentItem = new StudentItem();

        studentItem.setId(id);
        studentItem.setName(student.getName());
        studentItem.setPhoneNumber(student.getPhoneNumber());

        return studentItem;
    }
}
