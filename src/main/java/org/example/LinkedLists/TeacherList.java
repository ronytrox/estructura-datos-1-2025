package org.example.LinkedLists;

import org.example.Classes.Teacher;
import org.example.LinkedLists.Nodes.TeacherNode;

public class TeacherList {
    private TeacherNode head;
    int size = 0;

    public void addTeacher(Teacher teacher) {
        TeacherNode newNode = new TeacherNode(teacher);
        if (head == null) {
            head = newNode;

        } else {
            TeacherNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Teacher findById(String id) {
        TeacherNode current = head;
        while (current != null) {
            if (current.getTeacher().getId().equals(id)) {
                return current.getTeacher();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printAll() {
        if (head == null) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        TeacherNode current = head;
        while (current != null) {
            current.getTeacher().printInfo();
            current = current.getNext();
        }
    }


}
