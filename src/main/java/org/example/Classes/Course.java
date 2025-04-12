package org.example.Classes;

public class Course {
    private int id;
    private String groupNumber;
    private String description;
    private Teacher teacher;


    public Course(String groupNumber, String description) {
        this.id = 0;
        this.groupNumber = groupNumber;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String printInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Curso ID: ").append(id)
                .append(", Grupo: ").append(groupNumber)
                .append(", Descripción: ").append(description)
                .append("\n");

       return info.toString();
    }

}
