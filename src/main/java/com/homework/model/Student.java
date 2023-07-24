package com.homework.model;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private String surName;
    private int age;
    private int group;
    private int averageMark;

    public Student() {
    }

    public Student(int id, String name, String surName, int age, int group, int averageMark) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.group = group;
        this.averageMark = averageMark;
    }
}
