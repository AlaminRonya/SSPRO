package com.alamin.sse.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
public class Student {
    private int id;
    private String name;
    private float cgpa;

    public Student() {
        System.out.println("No-args Constructor::Student");
    }

    public Student(int id, String name, float cgpa) {
        System.out.println("All-args Constructor::Student");
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}