package org.example.LinkedLists.Nodes;

import org.example.Classes.Teacher;

public class TeacherNode {
    private final Teacher teacher;
    private TeacherNode next;

    public TeacherNode(Teacher teacher) {
        this.teacher = teacher;
        this.next = null;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public TeacherNode getNext() {
        return next;
    }

    public void setNext(TeacherNode next) {
        this.next = next;
    }
}
