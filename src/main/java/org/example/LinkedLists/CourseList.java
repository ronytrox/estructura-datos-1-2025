package org.example.LinkedLists;

import org.example.Classes.Course;
import org.example.LinkedLists.Nodes.CourseNode;

public class CourseList {
    private CourseNode head;
    private int idCounter = 1;
    int size = 0;

    public void addCourse(Course course) {
        course.setId(idCounter++);
        CourseNode newNode = new CourseNode(course);
        if (head == null) {
            head = newNode;
        } else {
            CourseNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Course findByGroupNumber(String groupNumber) {
        CourseNode current = head;
        while (current != null) {
            if (current.getCourse().getGroupNumber().equals(groupNumber)) {
                return current.getCourse();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String printAll() {
        if (head == null) {
            return "No hay cursos registrados.";
        }

        StringBuilder sb = new StringBuilder("Lista de Cursos:\n");
        CourseNode current = head;
        while (current != null) {
            sb.append(current.getCourse().printInfo()).append("\n");
            current = current.getNext();
        }

        return sb.toString().trim();
    }


}
