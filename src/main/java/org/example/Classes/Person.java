package org.example.Classes;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

abstract class Person {
    protected String id;
    protected String name;
    protected String firstLastName;
    protected String secondLastName;
    protected String email;
    protected String phone;
    protected String direction;
    protected String birthdate;
    protected int age;

    public Person(String id, String name, String firstLastName, String secondLastName,
                  String email, String phone, String direction, String birthdate) {
        this.id = id;
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.email = email;
        this.phone = phone;
        this.direction = direction;
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
        return name + " " + firstLastName + " " + secondLastName;
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

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBirthdate() {
        return birthdate;
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
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.printf ("║ %-42s ║%n", "Información de la Persona");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.printf ("║ %-20s: %-17s ║%n", "ID", id);
        System.out.printf ("║ %-20s: %-17s ║%n", "Nombre completo", getFullName());
        System.out.printf ("║ %-20s: %-17s ║%n", "Correo electrónico", email);
        System.out.printf ("║ %-20s: %-17s ║%n", "Teléfono", phone);
        System.out.printf ("║ %-20s: %-17s ║%n", "Dirección", direction);
        System.out.printf ("║ %-20s: %-17s ║%n", "Fecha de nacimiento", birthdate);
        System.out.printf ("║ %-20s: %-17d ║%n", "Edad", age);
        System.out.println("╚════════════════════════════════════════════╝");
    }


}
