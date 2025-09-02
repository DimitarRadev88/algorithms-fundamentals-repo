package com.dimitarrradev.recursionAndBacktracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PathsInLabyrinth {

    static Deque<Character> queue = new ArrayDeque<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        char[][] matrix = new char[rows][cols];

        IntStream.range(0, rows).forEach(i -> {
            matrix[i] = scanner.nextLine().toCharArray();
        });

        findPath(matrix, 0, 0, ' ');

    }

    private static void findPath(char[][] matrix, int row, int col, char direction) {
        if (!canMove(matrix, row, col)) {
            return;
        }

        if (matrix[row][col] == 'e') {
            queue.offer(direction);
            printPath();
            queue.removeLast();
            return;
        }

        matrix[row][col] = 'V';
        queue.offer(direction);

        findPath(matrix, row, col + 1, 'R');
        findPath(matrix, row + 1, col, 'D');
        findPath(matrix, row - 1, col, 'U');
        findPath(matrix, row, col - 1, 'L');

        queue.removeLast();
        matrix[row][col] = '-';

    }

    private static boolean canMove(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] != '*' && matrix[row][col] != 'V';
    }

    private static void printPath() {
        queue.stream().skip(1).forEach(System.out::print);
        System.out.println();
    }

}
