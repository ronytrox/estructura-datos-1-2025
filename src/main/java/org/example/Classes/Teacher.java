package org.example.Classes;

import org.example.LinkedLists.CourseList;
import org.example.LinkedLists.Nodes.CourseNode;

public class Teacher extends Person {

    private final CourseList courses = new CourseList();

    public Teacher(String id, String name, String firstLastName,String birthdate) {
        super(id, name, firstLastName,birthdate);

    }

    public CourseList getCourses() {
        return courses;
    }

    public void printCourses(){

        if(courses.isEmpty()){
            System.out.printf ("║ %-42s ║%n", "Sin cursos asignados");
        }
        else{
            System.out.printf ("║ %-42s ║%n", "Cursos asignados: ");
            printCoursesRecoursively(courses.peek());
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }

    public void printCoursesRecoursively(CourseNode course){
        if(course.getNext() != null){
            printCoursesRecoursively(course.getNext());
        }
        String courseId = "Curso " + course.getCourse().getId();
        String courseDescription = course.getCourse().getDescription();
        System.out.printf ("║ %-10s: %-30s ║%n", courseId, courseDescription);

    }

    public void addCourse(Course course) {
        courses.addCourse(course);
    }


    @Override
    public void printInfo() {
        super.printInfo();
        printCourses();
    }
}

