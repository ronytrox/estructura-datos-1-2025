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

    // Lista enlazada de estudiantes
    private final StudentList studentList = new StudentList();
    // Lista enlazada de profesores
    private final TeacherList teacherList = new TeacherList();
    // Lista enlazada de cursos
    private final CourseList courseList = new CourseList();
    private final EnrollmentList enrollmentList = new EnrollmentList();

    // ArrayList de estudiantes
    // ArrayList de profesores


    // Cola de cajas

    // Árbol binario de estudiantes
    // Árbol binario de profesores

    public void showMenu() throws IOException {

        boolean salir = false;
        while (!salir) {

            print("¡Bienvenido al sistema de la Universidad!");
            print("1. Registrar curso");
            print("2. Registrar estudiante");
            print("3. Registrar profesor");

            print("\n4. Matricular estudiante");
            print("5. Asignar un curso a un profesor");

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
                    //Crear cursos con id, número de grupo y una descripción del curso. (1%)
                    registerCourse();


                    break;
                case "2":
                    // El estudiante se agrega a la lista enlazada de estudiantes - Ronald
                    //Crear estudiante con id, nombre y demás atributos de estudiantes. (1%)
                    registerStudent();

                    // El estudiante se agrega a un arrayList en order alfabético por nombre o Id - Daniel Campos

                    // El estudiante se agrega a un árbol binario ordenado por cédula - Sebastíán

                    break;
                case "3":
                    // El profesor se agrega a la lista enlazada de profesores - Ronald
                    registerTeacher();

                    // El profesor se agrega a un arrayList en order alfabético por nombre o Id - Daniel Campos

                    // El profesor se agrega a un árbol binario ordenado por cédula - Sebastíán
                    break;
                case "4":
                    // Se asigna el curso al estudiante en la lista enlazada - Ronald
                    assignStudentToCourse();
                    break;
                case "5":
                    // Se asigna el curso al profesor en la lista enlazada - Ronald
                    assignTeacherToCourse();
                    break;
                case "6":
                    // Buscar estudiante por cédula en la lista enlazada - Daniel Marín
                    // Buscar estudiante por cédula e imprimir su información o indicar si no existe. (2%)
                    searchStudentByIdLinkedList();

                    break;
                case "7":
                    // Buscar estudiante por nombre en la lista enlazada - Daniel Marín
                    // Buscar estudiante por nombre e imprimir su información o indicar si no existe. (2%)
                    // Utilizar recursión para imprimir los cursos del estudiante

                    break;
                case "8":
                    // Buscar profesor por nombre en la lista enlazada y cursos asignados - Daniel Marín
                    // Buscar profesor por nombre e imprimir su información y cursos asignados para el cuatrimestre. (2%)
                    // Utilizar recursión para imprimir los cursos del profesor

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
                                // Agregar una persona a la cola de cajas - Sebastian
                                // Opción para ingresar una persona a atender (con ID y nombre).
                                // Utilizar una cola con listas enlazadas (LinkedList y Queue) vistas en clase
                                // Manejar cuando llega un anciano (senior), este debe agregarse al principio de la fila.

                                break;
                            case "2":
                                // Atender a la siguiente persona, sacándola - Sebastián
                                // Opción para atender a la siguiente persona, eliminándola de la cola.

                                break;
                            case "0":
                                print("Saliendo al menú principal");
                                break;
                        }
                    }
                    break;
                case "10":
                    // Buscar estudiantes en el arraylist ordenado con búsqueda binaria - Daniel Campos
                    // Por ID o nombre (con lo que se haya ordenado)

                    break;
                case "11":
                    // Buscar profesores en el arraylist ordenado con búsqueda binaria - Daniel Campos
                    // Por ID o nombre (con lo que se haya ordenado)
                    break;
                case "12":
                    // Buscar estudiantes en el árbol binario por ID - Sebastian
                    // Implementar un método de búsqueda eficiente en el BST.
                    break;
                case "13":
                    // Buscar profesores en el árbol binario por ID - Sebastian
                    // Implementar un método de búsqueda eficiente en el BST.
                    break;
                case "0":
                    print("Saliendo del sistema");
                    salir = true;
                    break;
            }

        }
    }

    private void registerCourse() throws IOException {
        String groupNumber = read("Número de grupo: ");
        String description = read("Descripción del curso: ");
        print(createCourse(groupNumber, description));
    }

    private void registerStudent() throws IOException {
        print("Por favor digite la información del estudiante:");
        String idStudent = read("Ingrese la cédula: ");
        String nameStudent = read("Ingrese el nombre: ");
        String firstLastNameStudent = read("Primer apellido: ");
        String birthdateStudent = read("Fecha de nacimiento (Formato dd-MM-yyyy): ");
        createStudent(idStudent,nameStudent,firstLastNameStudent,birthdateStudent);
    }

    private void registerTeacher() throws IOException {
        print("Por favor digite la información del profesor:");
        String idTeacher = read("Ingrese la cédula: ");
        String nameTeacher = read("Ingrese el nombre: ");
        String firstLastNameTeacher = read("Primer apellido: ");
        String birthdateTeacher = read("Fecha de nacimiento (Formato dd-MM-yyyy): ");
        createTeacher(idTeacher,nameTeacher,firstLastNameTeacher,birthdateTeacher);
    }

    private String createCourse(String groupNumber, String description) {

        Course course = new Course(groupNumber, description);
        courseList.addCourse(course);
        return ("Curso creado con ID: " + course.getId());

    }

    private void createStudent(String id, String name, String firstLastName, String birthdate) {

        Student student = new Student(id, name, firstLastName,birthdate);
        studentList.addStudent(student);
        print("Estudiante creado con ID: " + student.getId());
    }

    private void createTeacher(String id, String name, String firstLastName,String birthdate) {

        Teacher teacher = new Teacher(id, name, firstLastName,birthdate);
        teacherList.addTeacher(teacher);
        print("Profesor creado con ID: " + teacher.getId());
    }

    private void assignStudentToCourse() throws IOException{

        String studentId = read("Digite la cédula del estudiante: ");
        String courseNumber = read("Digite el número de curso: ");
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

    private void assignTeacherToCourse() throws IOException {

        String teacherId = read("Digite la cédula del profesor: ");
        String courseNumber = read("Digite el número de curso: ");
        Teacher teacher = teacherList.findById(teacherId);
        Course course = courseList.findByGroupNumber(courseNumber);

        if (teacher == null) {
            print("El profesor no fue encontrado.");
        } else if (course == null) {
            print("El curso no fue encontrado.");
        } else {
          course.setTeacher(teacher);
          teacher.addCourse(course);
          print("Profesor " + teacher.getName() + " agregado correctamente al curso de " + course.getDescription());
        }
    }

    private void showCourses() {
        if (courseList.isEmpty()) {
            print("No hay cursos registrados.");
        } else {
            print(courseList.printAll());
        }
    }

    private void searchStudentByIdLinkedList() throws IOException {
        String studentId = read("Digite la cédula del estudiante: ");
        Student student = studentList.findById(studentId);
        if(student == null) {
            print("El estudiante no fue encontrado.");
        }
        else{
            print("Estudiante encontrado:");
            student.printInfo();
        }
    }

    // Misc
    public static String read(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        print(s);
        return reader.readLine();
    }

    public static void print(Object s) {
        System.out.println(s);
    }

}
