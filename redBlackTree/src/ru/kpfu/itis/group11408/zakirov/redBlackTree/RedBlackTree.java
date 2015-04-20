package ru.kpfu.itis.group11408.zakirov.redBlackTree;

/**
 * Created by Anvar on 13.04.2015.
 */

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    enum Color {
        RED,
        BLACK;
    }
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private Color color;

        public Node(Key key, Value val, Color color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isRed(Node node) {
        if (node == null) return false;

        return node.color == Color.RED;
    }

    private Value get(Key key) {
        Node node = root;
        while (node != null) {
            int compareValue = key.compareTo(node.key);

            if (compareValue == 0)
                return node.val;

            node = (compareValue < 0) ? node.left : node.right;
        }

        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = Color.BLACK;
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) return new Node(key, val, Color.RED);

        int compareValue = key.compareTo(node.key);

        if (compareValue < 0)
            node.left = put(node.left,  key, val);
        else if (compareValue > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            swapColors(node);

        return node;
    }

    private Node rotateRight(Node node) {
        Node returnNode = node.left;
        node.left = returnNode.right;
        returnNode.right = node;
        returnNode.color = returnNode.right.color;
        returnNode.right.color = Color.RED;
        return returnNode;
    }

    private Node rotateLeft(Node node) {
        Node returnNode = node.right;
        node.right = returnNode.left;
        returnNode.left = node;
        returnNode.color = returnNode.left.color;
        returnNode.left.color = Color.RED;
        return returnNode;
    }

    private void swapColors(Node h) {
        h.color = (h.color == Color.BLACK) ? Color.RED : Color.BLACK;
        h.left.color = (h.left.color == Color.BLACK) ? Color.RED : Color.BLACK;
        h.right.color = (h.right.color == Color.BLACK) ? Color.RED : Color.BLACK;
    }

    public static void main(String[] args) {
        RedBlackTree<String, Integer> redBlackTree = new RedBlackTree<String, Integer>();
        redBlackTree.put("zero", 0);
        redBlackTree.put("one", 1);
        redBlackTree.put("two", 2);
        redBlackTree.put("three", 3);
        System.out.println(redBlackTree.get("zero"));
        System.out.println(redBlackTree.get("one"));
        System.out.println(redBlackTree.get("two"));
        System.out.println(redBlackTree.get("three"));
    }
}
