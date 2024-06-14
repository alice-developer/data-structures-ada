package main;

import dataStructures.Tree;
import problems.LargestTreeValues;

public class LargestTreeValuesSolve {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(100);

        tree.insert(10);
        tree.insert(5);

        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(5);

        System.out.println(LargestTreeValues.largestValues(tree));
    }
}
