package com.vojinp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void dfsSearch(Node node) {
        if (node == null) {
            return;
        }

        dfsSearch(node.getLeftChild());

        System.out.println(node);

        dfsSearch(node.getRightChild());
    }

    public void dfsWithStackSearch() {
        Stack<Node> stack = new Stack<>();
        Node tempNode = root;

        while (tempNode!= null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.getLeftChild();
            }

            tempNode = stack.pop();

            System.out.println(tempNode);

            tempNode = tempNode.getRightChild();
        }

    }

    public void idsSearch(int maxDepth) {
        for (int i = 1; i <= maxDepth; i++) {
            bfsRecursiveSearchWithDepth(Stream.of(root).collect(Collectors.toCollection(LinkedList::new)), 1, i);
        }
    }

    public void bfsRecursiveSearch(Queue<Node> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        Queue<Node> newNodes = new LinkedList();

        for (Node node: nodes) {
            System.out.println(node);
            if (node.getLeftChild() != null) {
                newNodes.add(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                newNodes.add(node.getRightChild());
            }
        }

        bfsRecursiveSearch(newNodes);
    }

    public void bfsRecursiveSearchWithDepth(Queue<Node> nodes, int depth, int maxDepth) {
        if (nodes.isEmpty() || depth > maxDepth) {
            return;
        }
        Queue<Node> newNodes = new LinkedList();

        for (Node node: nodes) {
            System.out.println(node);
            if (node.getLeftChild() != null) {
                newNodes.add(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                newNodes.add(node.getRightChild());
            }
        }

        bfsRecursiveSearchWithDepth(newNodes, depth + 1, maxDepth);
    }

    public void bfsSearch() {
        Queue<Node> nodes = new LinkedList();
        nodes.add(root);
        Node tempNode;

        while (!nodes.isEmpty()) {
            tempNode = nodes.remove();
            System.out.println(tempNode);
            if (tempNode.getLeftChild() != null) {
                nodes.add(tempNode.getLeftChild());
            }
            if (tempNode.getRightChild() != null) {
                nodes.add(tempNode.getRightChild());
            }
        }
    }
}
