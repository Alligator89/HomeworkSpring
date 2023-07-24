package com.homework.controller;

import com.homework.dao.StudentDao;
import com.homework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentDao studentDao;

    @Autowired
    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/show")
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentDao.showAllStudents());
        return "students/showAllStudents";
    }

    @GetMapping("show/{id}")
    public String showOneStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentDao.showOneStudent(id));
        return "students/showOneStudent";
    }

    @GetMapping("/new")
    public String createStudent(@ModelAttribute("student") Student student) {
        return "students/createStudent";
    }

    @PostMapping
    public String addStudent(@ModelAttribute("student") Student student) {
        studentDao.create(student);
        return "redirect:/students/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentDao.delete(id);
        return "redirect:/students/show";
    }
}
