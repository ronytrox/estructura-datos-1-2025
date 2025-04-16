package org.example.LinkedLists.Tree;

import org.example.Classes.Student;
import org.example.Classes.Teacher;
import org.example.LinkedLists.Nodes.TreeNode;

public class BST {
    private TreeNode root;

    public BST() {
        this.root = null;
    }

    // Método para insertar un nodo en el árbol binario de búsqueda
    public void insert(Object person) {
        root = insertRec(root, person);
    }

    private TreeNode insertRec(TreeNode root, Object person) {
        if (root == null) {
            root = new TreeNode(person);
            return root;
        }

        String id = "";
        if (person instanceof Student) {
            id = ((Student) person).getId();
        } else if (person instanceof Teacher) {
            id = ((Teacher) person).getId();
        }

        // Comparar el ID para insertar en el lado izquierdo o derecho
        String currentId = "";
        if (root.person instanceof Student) {
            currentId = ((Student) root.person).getId();
        } else if (root.person instanceof Teacher) {
            currentId = ((Teacher) root.person).getId();
        }

        if (id.compareTo(currentId) < 0) {
            root.left = insertRec(root.left, person);
        } else if (id.compareTo(currentId) > 0) {
            root.right = insertRec(root.right, person);
        }

        return root;
    }

    // Método para buscar una persona por ID
    public Object searchById(String id) {
        return searchRec(root, id);
    }

    private Object searchRec(TreeNode root, String id) {
        if (root == null) {
            return null;
        }

        String currentId = "";
        if (root.person instanceof Student) {
            currentId = ((Student) root.person).getId();
        } else if (root.person instanceof Teacher) {
            currentId = ((Teacher) root.person).getId();
        }

        if (currentId.equals(id)) {
            return root.person;
        }

        if (id.compareTo(currentId) < 0) {
            return searchRec(root.left, id);
        } else {
            return searchRec(root.right, id);
        }
    }

    // Método para mostrar el árbol (In-order traversal)
    public void printInOrder() {
        printInOrderRec(root);
    }

    private void printInOrderRec(TreeNode root) {
        if (root != null) {
            printInOrderRec(root.left);
            if (root.person instanceof Student) {
                Student s = (Student) root.person;
                System.out.println("Estudiante: " + s.getName() + " - " + s.getId());
            } else if (root.person instanceof Teacher) {
                Teacher t = (Teacher) root.person;
                System.out.println("Profesor: " + t.getName() + " - " + t.getId());
            }
            printInOrderRec(root.right);
        }
    }
}
