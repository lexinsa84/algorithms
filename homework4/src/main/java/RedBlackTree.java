package main.java;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node {
        int key;
        Node left, right;
        boolean color;

        Node(int key) {
            this.key = key;
            this.color = RED; // Новая нода всегда красная
        }
    }

    private Node root;

    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK; // Корень всегда черный
    }

    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
        // Балансировка дерева
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + (last ? "└── " : "├── ") + (node.color == RED ? "R" : "B") + node.key);
            indent += last ? "    " : "│   ";
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }
}
