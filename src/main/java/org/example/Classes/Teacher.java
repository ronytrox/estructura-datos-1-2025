package org.example.Classes;

import org.example.LinkedLists.CourseList;

public class Teacher extends Person {

    private final CourseList courses = new CourseList();

    public Teacher(String id, String name, String firstLastName,String birthdate) {
        super(id, name, firstLastName,birthdate);

    }

    public CourseList getCourses() {
        return courses;
    }

    public String printCourses(){
        return courses.printAll();
    }

    public void addCourse(Course course) {
        courses.addCourse(course);
    }


}

