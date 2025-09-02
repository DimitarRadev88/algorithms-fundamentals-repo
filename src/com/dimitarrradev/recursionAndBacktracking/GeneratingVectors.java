package com.dimitarrradev.recursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class GeneratingVectors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        int[] vector = new int[length];

        generateVectors(vector, 0);

    }

    private static void generateVectors(int[] vector, int index) {
        if (index == vector.length) {
            Arrays.stream(vector).forEach(System.out::print);
            System.out.println();
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generateVectors(vector, index + 1);
        }

    }

}
