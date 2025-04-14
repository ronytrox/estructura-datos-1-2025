package org.example.LinkedLists.Nodes;

public class TreeNode {
    public Object person;  // El objeto que se almacenará (puede ser un estudiante, un profesor, etc.)
    public TreeNode left;  // Nodo izquierdo
    public TreeNode right; // Nodo derecho

    // Constructor para inicializar el nodo con un objeto
    public TreeNode(Object person) {
        this.person = person;
        this.left = null;
        this.right = null;
    }
}
