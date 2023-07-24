package com.homework.dao;

import com.homework.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDao {
    private static int STUDENTS_COUNT;
    private final List<Student> students;

    {
        students = new ArrayList<>();
        students.add(new Student(++STUDENTS_COUNT, "Dima", "Petrov", 34, 10, 7));
        students.add(new Student(++STUDENTS_COUNT, "Sasha", "Ivanov", 36, 10, 9));
        students.add(new Student(++STUDENTS_COUNT, "Masha", "Kozlova", 30, 10, 6));
        students.add(new Student(++STUDENTS_COUNT, "Pasha", "Panov", 25, 10, 8));
    }

    public List<Student> showAllStudents() {
        return students;
    }

    public Student showOneStudent(int id) {
        return students.stream().filter(student -> student.getId() == id).findAny().orElse(null);
    }

    public void create(Student student) {
        student.setId(++STUDENTS_COUNT);
        students.add(student);
    }

    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
