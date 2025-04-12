package org.example.LinkedLists;

import org.example.Classes.Student;
import org.example.LinkedLists.Nodes.StudentNode;

public class StudentList {
    private StudentNode head;
    int size = 0;

    public void addStudent(Student student) {
        StudentNode newNode = new StudentNode(student);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Student findById(String id) {
        StudentNode current = head;
        while (current != null) {
            if (current.getStudent().getId().equalsIgnoreCase(id)) {
                return current.getStudent();
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
        StudentNode current = head;
        while (current != null) {
            current.getStudent().printInfo();
            current = current.getNext();
        }
    }

}
