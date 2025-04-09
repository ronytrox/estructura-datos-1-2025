package org.example;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    // Lista enlazada de cursos
    // Lista enlazada de estudiantes
    // Lista enlazada de profesores

    // ArrayList de estudiantes
    // ArrayList de profesores

    // Cola de cajas

    // Árbol binario de estudiantes
    // Árbol binario de profesores


    public static void main(String[] args) {

        MostrarMenu();
    }

    private static void MostrarMenu() {

        boolean salir = false;
        while (!salir) {


            System.out.println("Ingrese la opción deseada");
            System.out.println("1. Registrar curso");
            System.out.println("2. Registrar estudiante");
            System.out.println("3. Registrar profesor");

            System.out.println("\n4. Asignar curso a estudiante");
            System.out.println("5. Asignar curso a profesor");

            System.out.println("\n6. Buscar estudiante por ID en lista enlazada");
            System.out.println("7. Buscar estudiante por nombre en lista enlazada");
            System.out.println("8. Buscar profesor por nombre en lista enlazada");

            System.out.println("\n9. Atención en cajas");

            System.out.println("\n10. Búsqueda binaria de estudiantes");
            System.out.println("11. Búsqueda binaria de profesores");
            System.out.println("12. Buscar estudiante en árbol binario");
            System.out.println("13. Buscar profesor en árbol binario");

            System.out.println("\n0.Salir");

            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    // Registrar curso en lista enlazada de cursos - Ronald
                    //Crear cursos con id, número de grupo y una descripción del curso. (1%)

                    break;
                case "2":
                    // Preguntar nombre y cédula del estudiante
                    System.out.println("Ingrese la cédula del estudiante");
                    String cedulaEstudiante = sc.nextLine();
                    System.out.println("Ingrese el nombre del estudiante");
                    String nombreEstudiante = sc.nextLine();

                    // El estudiante se agrega a la lista enlazada de estudiantes - Ronald
                    //Crear estudiante con id, nombre y demás atributos de estudiantes. (1%)

                    // El estudiante se agrega a un arrayList en order alfabético por nombre o Id - Daniel Campos

                    // El estudiante se agrega a un árbol binario ordenado por cédula - Sebastíán
                    break;
                case "3":
                    // Preguntar nombre y cédula del profesor
                    System.out.println("Ingrese la cédula del profesor");
                    String cedulaProfesor = sc.nextLine();
                    System.out.println("Ingrese el nombre del profesor");
                    String nombreProfesor = sc.nextLine();

                    // El profesor se agrega a la lista enlazada de profesores - Ronald

                    // El profesor se agrega a un arrayList en order alfabético por nombre o Id - Daniel Campos

                    // El profesor se agrega a un árbol binario ordenado por cédula - Sebastíán

                    break;
                case "4":
                    // Se muestra la lista de estudiantes a elegir - Ronald
                    // Se muestra una lista de cursos a elegir
                    // Se asigna el curso al estudiante en la lista enlazada

                    break;

                case "5":
                    // Se muestra la lista de profesores a elegir - Ronald
                    // Se muestra una lista de cursos a elegir
                    // Se asigna el curso al profesor en la lista enlazada

                    break;
                case "6":
                    // Buscar estudiante por ID en la lista enlazada - Daniel Marín
                    // Buscar estudiante por ID e imprimir su información o indicar si no existe. (2%)

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
                    while (!opcion.equals("0")) {
                        System.out.println("Ingrese la opción deseada");
                        System.out.println("1. Agregar persona");
                        System.out.println("2. Atender a la siguiente persona");
                        System.out.println("0. Ir al menú principal");

                        opcion = sc.nextLine();
                        switch (opcion) {
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
                                System.out.println("Saliendo al menú principal");
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
                    System.out.println("Saliendo del sistema");
                    salir = true;
                    break;
            }
        }
    }
}

