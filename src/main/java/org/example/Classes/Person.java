package org.example.Classes;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

abstract class Person {
    protected String id;
    protected String name;
    protected String firstLastName;
    protected String birthdate;
    protected int age;

    public Person(String id, String name, String firstLastName, String birthdate) {
        this.id = id;
        this.name = name;
        this.firstLastName = firstLastName;
        this.birthdate = birthdate;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDateParsed = LocalDate.parse(birthdate, formatter);
        this.age = Period.between(birthDateParsed, LocalDate.now()).getYears();
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return name + " " + firstLastName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }


    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void printInfo() {
        String personType = this instanceof Teacher ? "profesor" : this instanceof Student? "estudiante" : "persona";
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.printf ("║ %-42s ║%n", "Información de " + personType);
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.printf ("║ %-20s: %-17s ║%n", "ID", id);
        System.out.printf ("║ %-20s: %-17s ║%n", "Nombre completo", getFullName());
        System.out.printf ("║ %-20s: %-17s ║%n", "Fecha de nacimiento", birthdate);
        System.out.printf ("║ %-20s: %-17d ║%n", "Edad", age);
        System.out.println("╚════════════════════════════════════════════╝");
    }


}
