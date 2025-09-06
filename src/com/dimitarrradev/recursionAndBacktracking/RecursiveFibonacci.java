package com.dimitarrradev.recursionAndBacktracking;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
