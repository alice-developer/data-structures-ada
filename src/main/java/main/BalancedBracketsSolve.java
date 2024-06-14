package main;

import problems.BalancedBrackets;

public class BalancedBracketsSolve {
    public static void main(String[] args) {
        System.out.println(BalancedBrackets.solve("[14*9(10+56) - (98-9]"));
        System.out.println(BalancedBrackets.solve("[14*9(10+56) - (98-9)]"));
    }
}