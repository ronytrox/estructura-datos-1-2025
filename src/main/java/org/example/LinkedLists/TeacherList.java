package org.example.LinkedLists;

import org.example.Classes.Student;
import org.example.Classes.Teacher;
import org.example.LinkedLists.Nodes.StudentNode;
import org.example.LinkedLists.Nodes.TeacherNode;

import java.util.ArrayList;

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

    public ArrayList<Teacher> findByName(String name) {
        TeacherNode current = head;
        ArrayList<Teacher> teachersFound = new ArrayList<>();
        String currentName;

        name = name.toLowerCase();

        while (current != null) {
            currentName = current.getTeacher().getFullName().toLowerCase();
            if (currentName.contains(name)) {
                teachersFound.add(current.getTeacher());
            }
            current = current.getNext();
        }
        return teachersFound;
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

    public void printAllSummarized() {
        if (head == null) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        TeacherNode current = head;
        while (current != null) {
            System.out.print(current.getTeacher().getId() + " - " + current.getTeacher().getFullName() + "\n");
            current = current.getNext();
        }
    }


}
