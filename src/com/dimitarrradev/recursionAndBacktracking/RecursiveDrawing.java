package com.dimitarrradev.recursionAndBacktracking;

import java.util.Scanner;

public class RecursiveDrawing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        printFigure(size);

    }

    private static void printFigure(int size) {
        if (size == 0) {
            return;
        }

        System.out.println("*".repeat(size));
        printFigure(size - 1);
        System.out.println("#".repeat(size));
    }

}
