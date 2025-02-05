package main.java;

public class Program {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        int[] values = {10, 20, 30, 15, 25, 5, 1};

        for (int value : values) {
            tree.insert(value);
        }

        tree.printTree();
        tree.printtTree();
    }
}
