package com.vojinp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Node root = new Node("1");
        Tree tree = new Tree(root);
        Node two = new Node("2");

        root.setLeftChild(two);
        root.setRightChild(new Node("3"));

        two.setLeftChild(new Node("4"));
        two.setRightChild(new Node("5"));

        tree.dfsSearch(tree.getRoot());
        System.out.println("-----");
        tree.dfsWithStackSearch();
        System.out.println("-----");
        tree.bfsRecursiveSearch(Stream.of(root).collect(Collectors.toCollection(LinkedList::new)));
        System.out.println("-----");
        tree.bfsSearch();
        System.out.println("-----");
        tree.idsSearch(3);
    }
}
