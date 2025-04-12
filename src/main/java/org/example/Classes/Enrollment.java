package org.example.Classes;

import java.time.LocalDate;

public class Enrollment {
    private final Student student;
    private final Course course;
    private final LocalDate enrollmentDate;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }

    public String printInfo() {
        return "Estudiante: " + student.getName() + " " + student.getFirstLastName() +
                " | Curso: " + course.getDescription() +
                " | Fecha de matrícula: " + enrollmentDate;
    }
}
