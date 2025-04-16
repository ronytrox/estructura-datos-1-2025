package org.example.LinkedLists;

import org.example.Classes.Student;
import org.example.Classes.Teacher;
import org.example.LinkedLists.Nodes.QueueNode;

public class QueueList {

    private QueueNode head;
    private QueueNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    private boolean isSenior(Object person) {
        int age;
        if (person instanceof Student) {
            age = ((Student) person).getAge();
        } else if (person instanceof Teacher) {
            age = ((Teacher) person).getAge();
        } else {
            return false;
        }

        try {
            return age >= 65;
        } catch (Exception e) {
            return false;
        }
    }

    public void enqueue(Object person) {
        QueueNode newNode = new QueueNode(person);

        if (isSenior(person)) {
            newNode.next = head;
            head = newNode;
            if (tail == null) tail = head;
        } else {
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    public Object dequeue() {
        if (isEmpty()) return null;
        Object person = head.person;
        head = head.next;
        if (head == null) tail = null;
        return person;
    }

    public void printQueue() {
        QueueNode current = head;
        System.out.println("Cola actual:");
        while (current != null) {
            Object person = current.person;
            if (person instanceof Student) {
                Student s = (Student) person;
                System.out.println("Estudiante: " + s.getName() + " - " + s.getId());
            } else if (person instanceof Teacher) {
                Teacher t = (Teacher) person;
                System.out.println("Profesor: " + t.getName() + " - " + t.getId());
            }
            current = current.next;
        }
    }

    // Método para agregar una persona a la cola
    public void addPerson(String name, String id, boolean isStudent, String lastName, String birthdate) {
        if (isStudent) {
            Student student = new Student(id, name, lastName, birthdate);
            enqueue(student);
            System.out.println("Estudiante agregado: " + student.getName());
        } else {
            // Crear un profesor
            Teacher teacher = new Teacher(id, name, lastName, birthdate);
            enqueue(teacher);
            System.out.println("Profesor agregado: " + teacher.getName());
        }
    }
    

    // Método para atender a la siguiente persona
    public void servePerson() {
        Object servedPerson = dequeue();
        if (servedPerson == null) {
            System.out.println("No hay personas en la cola.");
        } else {
            if (servedPerson instanceof Student) {
                Student s = (Student) servedPerson;
                System.out.println("Atendiendo a estudiante: " + s.getName() + " - " + s.getId());
            } else if (servedPerson instanceof Teacher) {
                Teacher t = (Teacher) servedPerson;
                System.out.println("Atendiendo a profesor: " + t.getName() + " - " + t.getId());
            }
        }
    }
}
