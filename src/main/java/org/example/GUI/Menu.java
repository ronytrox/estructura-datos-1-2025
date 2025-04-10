package org.example.GUI;

import org.example.Classes.Course;
import org.example.Classes.Student;
import org.example.Classes.Teacher;
import org.example.LinkedLists.CourseList;
import org.example.LinkedLists.EnrollmentList;
import org.example.LinkedLists.StudentList;
import org.example.LinkedLists.TeacherList;

import java.io.*;


public class Menu {

    private final StudentList studentList = new StudentList();
    private final TeacherList teacherList = new TeacherList();
    private final CourseList courseList = new CourseList();
    private final EnrollmentList enrollmentList = new EnrollmentList();

    public void showMenu() throws IOException {

        boolean salir = false;
        while (!salir) {

            print("¡Bienvenido al sistema de la Universidad!");
            print("1. Registrar curso");
            print("2. Registrar estudiante");
            print("3. Registrar profesor");

            print("\n4. Asignar curso a estudiante");
            print("5. Asignar curso a profesor");

            print("\n6. Buscar estudiante por ID en lista enlazada");
            print("7. Buscar estudiante por nombre en lista enlazada");
            print("8. Buscar profesor por nombre en lista enlazada");

            print("\n9. Atención en cajas");

            print("\n10. Búsqueda binaria de estudiantes");
            print("11. Búsqueda binaria de profesores");
            print("12. Buscar estudiante en árbol binario");
            print("13. Buscar profesor en árbol binario");

            print("\n0.Salir");

            String option = read("Seleccione la opción deseada");

            switch (option) {
                case "1":
                    // Registrar curso en lista enlazada de cursos - Ronald
                    String groupNumber = read("Número de grupo: ");
                    String description = read("Descripción del curso: ");
                    print(createCourse(groupNumber, description));
                    break;
                case "2":
                    print("Por favor digite la información del estudiante:");
                    String idStudent = read("Ingrese la cédula: ");
                    String nameStudent = read("Ingrese el nombre: ");
                    String firstLastNameStudent = read("Primer apellido: ");
                    String secondLastNameStudent = read("Segundo apellido: ");
                    String emailStudent = read("Email: ");
                    String phoneStudent = read("Teléfono: ");
                    String addressStudent = read("Dirección: ");
                    String birthdateStudent = read("Fecha de nacimiento (Formato dd-MM-yyy): ");
                    createStudent(idStudent,nameStudent,firstLastNameStudent,secondLastNameStudent,emailStudent,phoneStudent,addressStudent,birthdateStudent);
                    break;
                case "3":
                    print("Por favor digite la información del docente:");
                    String idTeacher = read("Ingrese la cédula: ");
                    String nameTeacher = read("Ingrese el nombre: ");
                    String firstLastNameTeacher = read("Primer apellido: ");
                    String secondLastNameTeacher = read("Segundo apellido: ");
                    String emailTeacher = read("Email: ");
                    String phoneTeacher = read("Teléfono: ");
                    String addressTeacher = read("Dirección: ");
                    String birthdateTeacher = read("Fecha de nacimiento (Formato dd-MM-yyy): ");
                    createTeacher(idTeacher,nameTeacher,firstLastNameTeacher,secondLastNameTeacher,emailTeacher,phoneTeacher,addressTeacher,birthdateTeacher);
                    break;
                case "4":
                    // Asignar curso a estudiante
                    String studentId = read("Digite la cédula del estudiante: ");
                    String courseNumberStudent = read("Digite el número de curso: ");
                    assignStudentToCourse(studentId,courseNumberStudent);
                    break;
                case "5":
                    // Asignar curso a profesor
                    String teacherId = read("Digite la cédula del profesor: ");
                    String courseNumberTeacher = read("Digite el número de curso: ");
                    assignTeacherToCourse(teacherId,courseNumberTeacher);
                    break;
                case "6":
                    // Buscar estudiante por ID
                    break;
                case "7":
                    // Buscar estudiante por nombre
                    break;
                case "8":
                    // Buscar profesor por nombre
                    break;
                case "9":
                    while (!option.equals("0")) {
                        print("Ingrese la opción deseada");
                        print("1. Agregar persona");
                        print("2. Atender a la siguiente persona");
                        print("0. Ir al menú principal");

                        option = read("");
                        switch (option) {
                            case "1":
                                // Agregar persona a la cola
                                break;
                            case "2":
                                // Atender persona
                                break;
                            case "0":
                                print("Saliendo al menú principal");
                                break;
                        }
                    }
                    break;
                case "10":
                    // Búsqueda binaria estudiantes
                    break;
                case "11":
                    // Búsqueda binaria profesores
                    break;
                case "12":
                    // Buscar estudiante en árbol
                    break;
                case "13":
                    // Buscar profesor en árbol
                    break;
                case "0":
                    print("Saliendo del sistema");
                    salir = true;
                    break;
            }

        }
    }

    private String createCourse(String groupNumber, String description) {

        Course course = new Course(groupNumber, description);
        courseList.addCourse(course);
        return ("Curso creado con ID: " + course.getId());

    }

    private void createStudent(String id, String name, String firstLastName, String secondLastName,
                               String email, String phone, String address, String birthdate) {

        Student student = new Student(id, name, firstLastName, secondLastName, email, phone, address, birthdate);
        studentList.addStudent(student);
        print("Estudiante creado con ID: " + student.getId());
    }

    private void createTeacher(String id, String name, String firstLastName, String secondLastName,
                               String email, String phone, String address, String birthdate) {

        Teacher teacher = new Teacher(id, name, firstLastName, secondLastName, email, phone, address, birthdate);
        teacherList.addTeacher(teacher);
        print("Profesor creado con ID: " + teacher.getId());
    }

    private void assignStudentToCourse(String studentId, String courseNumber) {

        Student student = studentList.findById(studentId);
        Course course = courseList.findByGroupNumber(courseNumber);

        if (student == null) {
            print("El estudiante no fue encontrado.");
        } else if (course == null) {
            print("El curso no fue encontrado.");
        } else {
            print(enrollmentList.enroll(student, course));
        }
    }

    private void assignTeacherToCourse(String teacherId, String courseNumber) {

        Teacher teacher = teacherList.findById(teacherId);
        Course course = courseList.findByGroupNumber(courseNumber);

        if (teacher == null) {
            print("El profesor no fue encontrado.");
        } else if (course == null) {
            print("El curso no fue encontrado.");
        } else {
          course.setTeacher(teacher);
          teacher.addCourse(course);
        }
    }

    private void showCourses() {
        if (courseList.isEmpty()) {
            print("No hay cursos registrados.");
        } else {
            print(courseList.printAll());
        }
    }

    public static String read(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        print(s);
        return reader.readLine();
    }

    public static void print(Object s) {
        System.out.println(s);
    }

}
