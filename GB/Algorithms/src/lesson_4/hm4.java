package lesson_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class hm4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RedBlackTree1 tree = new RedBlackTree1();
        for (int i = 0; i < 12; i++) {
            int element = sc.nextInt();
            tree.add(element);
            tree.print();
            //5 11 6 7 2 9 12 1 10 3 8 4
        }
    }
}

class RedBlackTree1 {
    Node root;

    private class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    // пфункция для тестирования дерева
    public void print() {
        print(root, 0);
    }

    private void print(Node node, int i) {
        if (node != null) {
            System.out.printf("%d: ", i);
            System.out.println(node);
            i++;
            print(node.leftChild, i);
            print(node.rightChild, i);
        }
    }

    private enum Color {
        RED, BLACK;
    }

    public boolean add(int value) {
        if (root != null) {
            boolean result = add(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean add(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = add(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = add(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        boolean needRebalance;
        do {
            needRebalance = false;
            if (node.rightChild != null && node.rightChild.color == Color.RED &&
                    (node.leftChild == null || node.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                node = rightSwap(node);
            }
            if (node.leftChild != null && node.leftChild.color == Color.RED &&
                    node.leftChild.leftChild != null && node.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                node = leftSwap(node);
            }
            if (node.leftChild != null && node.leftChild.color == Color.RED &&
                    node.rightChild != null && node.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(node);
            }
        } while (needRebalance);

        return node;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        // node = rightChild;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }
}

