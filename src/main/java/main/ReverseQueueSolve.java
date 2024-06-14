package main;

import problems.ReverseQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueSolve {
    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println(ReverseQueue.reverseFirstK(numbers, 2));
    }
}
