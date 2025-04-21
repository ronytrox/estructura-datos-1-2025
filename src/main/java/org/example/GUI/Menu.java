package org.example.GUI;

import org.example.Classes.Course;
import org.example.Classes.Student;
import org.example.Classes.Teacher;
import org.example.LinkedLists.CourseList;
import org.example.LinkedLists.EnrollmentList;
import org.example.LinkedLists.StudentList;
import org.example.LinkedLists.TeacherList;
import org.example.LinkedLists.QueueList;
import org.example.LinkedLists.Tree.BST;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Menu {

    // Lista enlazada de estudiantes
    private final StudentList studentList = new StudentList();
    // Lista enlazada de profesores
    private final TeacherList teacherList = new TeacherList();
    // Lista enlazada de cursos
    private final CourseList courseList = new CourseList();
    private final EnrollmentList enrollmentList = new EnrollmentList();

    // ArrayList de estudiantes
    private final ArrayList<Student> studentsArrayList = new ArrayList<>();
    // ArrayList de profesores
    private final ArrayList<Teacher> teachersArrayList = new ArrayList<>();

    // Cola de cajas
    private final QueueList attentionQueue = new QueueList();

    // Creación del árbol binario de búsqueda (BST)
    BST bst = new BST();

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
                    // Crear cursos con id, número de grupo y una descripción del curso. (1%)
                    registerCourse();

                    break;
                case "2":
                    // El estudiante se agrega a la lista enlazada de estudiantes - Ronald
                    // Crear estudiante con id, nombre y demás atributos de estudiantes. (1%)
                    registerStudent();

                    // El estudiante se agrega a un árbol binario ordenado por cédula - Sebastíán

                    break;
                case "3":
                    // El profesor se agrega a la lista enlazada de profesores - Ronald
                    registerTeacher();

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
                    // Buscar estudiante por cédula e imprimir su información o indicar si no
                    // existe. (2%)
                    searchStudentByIdLinkedList();

                    break;
                case "7":
                    // Buscar estudiante por nombre en la lista enlazada - Daniel Marín
                    // Buscar estudiante por nombre e imprimir su información o indicar si no
                    // existe. (2%)
                    // Utilizar recursión para imprimir los cursos del estudiante
                    searchStudentByNameLinkedList();

                    break;
                case "8":
                    // Buscar profesor por nombre en la lista enlazada y cursos asignados - Daniel
                    // Marín
                    // Buscar profesor por nombre e imprimir su información y cursos asignados para
                    // el cuatrimestre. (2%)
                    // Utilizar recursión para imprimir los cursos del profesor
                    searchTeacherByNameLinkedList();

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
                                // Solicitar datos y agregar persona
                                addPersonToQueue();
                                break;
                            case "2":
                                // Atender a la siguiente persona
                                attentionQueue.servePerson();
                                break;
                            case "0":
                                print("Saliendo al menú principal");
                                break;
                        }
                    }
                    break;
                case "10":
                    // Buscar estudiantes en el arraylist ordenado con búsqueda binaria - Daniel
                    // Campos
                    studentsBinarySearch(studentsArrayList);

                    break;
                case "11":
                    // Buscar profesores en el arraylist ordenado con búsqueda binaria - Daniel
                    // Campos
                    teachersBinarySearch(teachersArrayList);

                    break;
                case "12":
                    // Buscar estudiantes en el árbol binario por ID - Sebastian
                    searchStudentByIdBST();

                    break;
                case "13":
                    // Buscar profesores en el árbol binario por ID - Sebastian
                    searchTeacherByIdBST();

                    break;
                case "0":
                    print("Saliendo del sistema");
                    salir = true;
                    break;
            }

            promptForEnterKey();

        }
    }

    private void registerCourse() throws IOException {
        String description = read("Descripción del curso: ");
        String groupNumber = read("Número de grupo: ");
        print(createCourse(groupNumber, description));
    }

    private void registerStudent() throws IOException {
        print("Por favor digite la información del estudiante:");
        String idStudent = read("Ingrese la cédula: ");

        // Validación
        Student student = studentList.findById(idStudent);
        if (student != null) {
            print("Un estudiante con esta cédula ya existe en el registro");
            student.printInfo();
            return;
        }

        String nameStudent = read("Ingrese el nombre: ");
        String firstLastNameStudent = read("Ingrese el primer apellido: ");
        String birthdateStudent = requestBirtdate();

        createStudent(idStudent, nameStudent, firstLastNameStudent, birthdateStudent);
    }

    private void registerTeacher() throws IOException {
        print("Por favor digite la información del profesor:");
        String idTeacher = read("Ingrese la cédula: ");

        // Validación
        Teacher teacher = teacherList.findById(idTeacher);
        if (teacher != null) {
            print("Un profesor con esta cédula ya existe en el registro");
            teacher.printInfo();
            return;
        }

        String nameTeacher = read("Ingrese el nombre: ");
        String firstLastNameTeacher = read("Ingrese el primer apellido: ");
        String birthdateTeacher = requestBirtdate();

        createTeacher(idTeacher, nameTeacher, firstLastNameTeacher, birthdateTeacher);
    }

    private String createCourse(String groupNumber, String description) {

        Course course = new Course(groupNumber, description);
        courseList.addCourse(course);
        return ("Curso creado con ID: " + course.getId());

    }

    private void createStudent(String id, String name, String firstLastName, String birthdate) {

        Student student = new Student(id, name, firstLastName, birthdate);
        studentList.addStudent(student);

        // Para busqueda binaria
        studentsArrayList.add(student);
        studentsBubbleSort(studentsArrayList);

        //Para árbol binario
        bst.insert(student);

        print("Estudiante creado con ID: " + student.getId());

    }

    private void createTeacher(String id, String name, String firstLastName, String birthdate) {

        Teacher teacher = new Teacher(id, name, firstLastName, birthdate);
        teacherList.addTeacher(teacher);

        // Para busqueda binaria
        teachersArrayList.add(teacher);
        teachersBubbleSort(teachersArrayList);

        // Para árbol binario
        bst.insert(teacher);

        print("Profesor creado con ID: " + teacher.getId());
    }

    private void assignStudentToCourse() throws IOException {

        Student student = getStudentForAssignemnt();
        if (student == null) {
            return;
        }

        Course course = getCourseForAssignment();
        if (course == null) {
            return;
        }

        print(enrollmentList.enroll(student, course));

    }

    private void assignTeacherToCourse() throws IOException {

        Teacher teacher = getTeacherForAssignemnt();
        if (teacher == null) {
            return;
        }

        Course course = getCourseForAssignment();
        if (course == null) {
            return;
        }

        course.setTeacher(teacher);
        teacher.addCourse(course);
        print("Profesor " + teacher.getName() + " agregado correctamente al curso de " + course.getDescription());

    }

    private void searchStudentByIdLinkedList() throws IOException {
        String studentId = read("Digite la cédula del estudiante: ");
        Student student = studentList.findById(studentId);
        if (student == null) {
            print("El estudiante no fue encontrado.");
        } else {
            student.printInfo();
            enrollmentList.printEnrollmentsByStudent(student.getId());
        }
    }

    private void searchStudentByNameLinkedList() throws IOException {
        String studentName = read("Digite el nombre del estudiante: ");
        ArrayList<Student> students = studentList.findByName(studentName);
        if (students.isEmpty()) {
            print("No se encontró ningún estudiante el nombre proporcionado.");
        } else {
            print("Estudiantes encontrados: \n");
            for (Student student : students) {
                student.printInfo();
                enrollmentList.printEnrollmentsByStudent(student.getId());
            }
        }
    }

    private void searchTeacherByNameLinkedList() throws IOException {
        String teacherName = read("Digite el nombre del profesor: ");
        ArrayList<Teacher> teachers = teacherList.findByName(teacherName);
        if (teachers.isEmpty()) {
            print("No se encontró ningún profesor el nombre proporcionado.");
        } else {
            print("Profesores encontrados: \n");
            for (Teacher teacher : teachers) {
                teacher.printInfo();
            }
        }
    }

    private Course getCourseForAssignment() throws IOException {
        String courseId = read("Digite el id del grupo o digite \"0\" para imprimir una lista de cursos y grupos: ");
        if (courseId.equals("0")) {
            courseList.printAllSummarized();
            courseId = read("Digite el id del grupo: ");
        }

        Course course = courseList.findById(courseId);
        if (course == null) {
            print("El curso no fue encontrado.");
            return null;
        }

        return course;
    }

    private Student getStudentForAssignemnt() throws IOException {
        String studentId = read("Digite la cédula del estudiante o digite \"0\" para imprimir una lista de estudiantes: ");
        if (studentId.equals("0")) {
            studentList.printAllSummarized();
            studentId = read("Digite la cédula del estudiante: ");
        }
        Student student = studentList.findById(studentId);
        if (student == null) {
            print("No se encontró ningún estudiante con la cédula proporcionada.");
            return null;
        }

        return student;
    }

    private Teacher getTeacherForAssignemnt() throws IOException {
        String teacherId = read("Digite la cédula del profesor o digite \"0\" para imprimir una lista de profesores: ");
        if (teacherId.equals("0")) {
            teacherList.printAllSummarized();
            teacherId = read("Digite la cédula del profesor: ");
        }
        Teacher teacher = teacherList.findById(teacherId);

        if (teacher == null) {
            print("No se encontró ningún profesor con la cédula proporcionada.");
            return null;
        }

        return teacher;
    }

    public static void studentsBubbleSort(ArrayList<Student> array) {
        int n = array.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {
                if (Integer.parseInt(array.get(j).getId()) > Integer.parseInt(array.get(j + 1).getId())) {
                    Student temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }

        }
    }

    public static void teachersBubbleSort(ArrayList<Teacher> array) {
        int n = array.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {
                if (Integer.parseInt(array.get(j).getId()) > Integer.parseInt(array.get(j + 1).getId())) {
                    Teacher temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }

        }
    }

    public void studentsBinarySearch(ArrayList<Student> studentsArrayList) throws IOException {
        int studentId = Integer.parseInt(read("Ingrese el ID del estudiante"));
        print("Buscando estudiante con ID: " + studentId);
        int studentIndex = studentsBinarySearchById(studentsArrayList, studentId);
        if (studentIndex != -1) {
            studentsArrayList.get(studentIndex).printInfo();
            enrollmentList.printEnrollmentsByStudent(studentsArrayList.get(studentIndex).getId());
        } else {
            print("No existe el estudiante con ID: " + studentId);
        }
    }

    public static int studentsBinarySearchById(ArrayList<Student> list, int id) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = Integer.parseInt(list.get(mid).getId());

            if (midId == id) {
                return mid; // encontrado
            } else if (midId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // no encontrado
    }

    public static void teachersBinarySearch(ArrayList<Teacher> teachersArrayList) throws IOException {
        int teacherId = Integer.parseInt(read("Ingrese el ID del profesor"));
        print("Buscando profesor con ID: " + teacherId);
        int teacherIndex = teachersBinarySearchById(teachersArrayList, teacherId);
        if (teacherIndex != -1) {
            teachersArrayList.get(teacherIndex).printInfo();
        } else {
            print("No existe el profesor con ID: " + teacherId);
        }
    }

    public static int teachersBinarySearchById(ArrayList<Teacher> list, int id) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = Integer.parseInt(list.get(mid).getId());

            if (midId == id) {
                return mid; // encontrado
            } else if (midId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // no encontrado
    }

    private void addPersonToQueue() throws IOException{
        
        String isStudentAnswer = read("¿Es estudiante? (Digite s/n): ").trim().toLowerCase();
        
        boolean isStudent = isStudentAnswer.equals("s");

        // Solicitar Id
        String id = read("Ingrese el ID de la persona: ");

        // Solicitar nombre
        String name = read("Ingrese el nombre de la persona: ");

        // Solicitar apellido
        String lastName = read("Ingrese el apellido de la persona: ");

        // Solicitar fecha de nacimiento
        String birthdate = requestBirtdate();

        // Agregar la persona
        attentionQueue.addPerson(name, id, isStudent, lastName, birthdate);
    }

    private void searchStudentByIdBST() throws IOException {
        String studentId = read("Ingrese el ID del estudiante que desea buscar: "); // Leer el ID del estudiante
        Object student = bst.searchById(studentId); // Usar el método searchById para buscar al estudiante

        if (student != null && student instanceof Student) {
            // Si se encuentra un estudiante
            Student foundStudent = (Student) student;
            print("Estudiante encontrado: " + foundStudent.getName() + " - " + foundStudent.getId());
            foundStudent.printInfo();
            enrollmentList.printEnrollmentsByStudent(foundStudent.getId());

        } else {
            // Si no se encuentra el estudiante
            print("Estudiante con ID " + studentId + " no encontrado.");
        }
    }

    private void searchTeacherByIdBST() throws IOException{
        String teacherId = read("Ingrese el ID del profesor que desea buscar: "); // Leer el ID del profesor
        Object teacher = bst.searchById(teacherId); // Usar el método searchById para buscar al profesor

        if (teacher != null && teacher instanceof Teacher) {
            // Si se encuentra un profesor
            Teacher foundTeacher = (Teacher) teacher;
            print("Profesor encontrado: " + foundTeacher.getName() + " - " + foundTeacher.getId());
            foundTeacher.printInfo();
        } else {
            // Si no se encuentra el profesor
            print("Profesor con ID " + teacherId + " no encontrado.");
        }
    }

    // Misc
    public static String read(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        print(s);
        return reader.readLine().trim();
    }

    public static void print(Object s) {
        System.out.println(s);
    }

    public void promptForEnterKey() throws IOException {
        print("Presione \"ENTER\" para continuar...");
        int read = System.in.read(new byte[2]);
    }

    private String requestBirtdate() throws IOException {
        String birthdate = null;
        boolean validDate = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (!validDate) {
            try {
                birthdate = read("Ingrese la fecha de nacimiento (Formato dd-MM-yyyy): ");
                LocalDate.parse(birthdate, formatter);
                validDate = true;
            } catch (DateTimeParseException e) {
                print("Fecha ingresada con formato incorrecto. Intente de nuevo.");
            }
        }
        return birthdate;
    }

}
