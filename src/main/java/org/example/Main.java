package org.example;
import org.example.GUI.Menu;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.showMenu();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

}

