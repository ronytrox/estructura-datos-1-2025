package org.example.LinkedLists.Nodes;

import org.example.Classes.Student;


public class StudentNode {
    private final Student student;
    private StudentNode next;

    public StudentNode(Student student) {
        this.student = student;
        this.next = null;
    }

    public Student getStudent() {
        return student;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }
}

