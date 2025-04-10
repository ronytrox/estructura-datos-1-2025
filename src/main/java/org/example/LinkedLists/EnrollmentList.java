package org.example.LinkedLists;

import org.example.Classes.Course;
import org.example.Classes.Enrollment;
import org.example.Classes.Student;
import org.example.LinkedLists.Nodes.EnrollmentNode;

public class EnrollmentList {
    private EnrollmentNode head;
    int size = 0;

    public String enroll(Student student, Course course) {
        Enrollment enrollment = new Enrollment(student, course);
        EnrollmentNode newNode = new EnrollmentNode(enrollment);
        if (head == null) {
            head = newNode;
        } else {
            EnrollmentNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
        return "Matrícula realizada exitosamente:\n" + enrollment.printInfo();
    }

    public String printAll() {
        if (head == null) {
            return "No hay matrículas registradas.";
        }

        EnrollmentNode current = head;
        StringBuilder sb = new StringBuilder("Lista de Matrículas:\n");
        while (current != null) {
            sb.append(current.getEnrollment().printInfo()).append("\n");
            current = current.getNext();
        }
        return sb.toString().trim(); // Elimina el último salto de línea
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Buscar matrículas por estudiante
    public String printEnrollmentsByStudent(String studentId) {
        EnrollmentNode current = head;
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        while (current != null) {
            if (current.getEnrollment().getStudent().getId().equals(studentId)) {
                sb.append(current.getEnrollment().printInfo()).append("\n");
                found = true;
            }
            current = current.getNext();
        }
        return found ? sb.toString().trim() : "El estudiante no tiene matrículas registradas.";
    }

    // Buscar matrículas por curso
    public String printEnrollmentsByCourse(int courseId) {
        EnrollmentNode current = head;
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        while (current != null) {
            if (current.getEnrollment().getCourse().getId() == courseId) {
                sb.append(current.getEnrollment().printInfo()).append("\n");
                found = true;
            }
            current = current.getNext();
        }
        return found ? sb.toString().trim() : "El curso no tiene estudiantes inscritos.";
    }
}
