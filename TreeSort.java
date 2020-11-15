package com.company;

public class TreeSort {

    public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    public TreeSort() {
        root = null;
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.key)
            node.left = insert(node.left, key);

        else if (key > node.key)
            node.right = insert(node.right, key);

        return node;
    }

    public void dfs(Node node) {
        if (node != null) {
            dfs(node.left);
            int nodeValue = node.key;
            dfs(node.right);
        }
    }

    public void sort(int[] arr) {
        long startTime = System.nanoTime();

        for (int j : arr) {
            root = insert(root, j);
        }

        dfs(root);

        long stopTime = System.nanoTime();

        System.out.println("\n\nTree Sort Start Time: " + startTime);
        System.out.println("\nTree Sort Stop Time: " + stopTime);
        System.out.println("\nTime Taken To Tree Sort: " + (stopTime - startTime));
    }
}
