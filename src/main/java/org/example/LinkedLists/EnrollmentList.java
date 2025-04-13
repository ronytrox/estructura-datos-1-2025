package org.example.LinkedLists;

import org.example.Classes.Course;
import org.example.Classes.Enrollment;
import org.example.Classes.Student;
import org.example.LinkedLists.Nodes.EnrollmentNode;

import java.util.ArrayList;

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
    public void printEnrollmentsByStudent(String studentId) {
        EnrollmentNode current = head;
        ArrayList<Course> courses = new ArrayList<>();
        while (current != null) {
            if (current.getEnrollment().getStudent().getId().equals(studentId)) {
                courses.add(current.getEnrollment().getCourse());
            }
            current = current.getNext();
        }
        if(courses.isEmpty()) {
            System.out.printf ("║ %-42s ║%n", "Sin cursos asignados");
        }
        else{
            System.out.printf ("║ %-42s ║%n", "Cursos matriculados: ");
            for(Course course : courses) {
                String courseId = "Curso " + course.getId();
                String courseDescription = course.getDescription() + " - Grp. " + course.getGroupNumber();
                System.out.printf ("║ %-10s: %-30s ║%n", courseId, courseDescription);
            }
        }
        System.out.println("╚════════════════════════════════════════════╝");

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
