package org.example.LinkedLists.Nodes;

import org.example.Classes.Enrollment;

public class EnrollmentNode {
    private final Enrollment enrollment;
    private EnrollmentNode next;

    public EnrollmentNode(Enrollment enrollment) {
        this.enrollment = enrollment;
        this.next = null;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public EnrollmentNode getNext() {
        return next;
    }

    public void setNext(EnrollmentNode next) {
        this.next = next;
    }
}
