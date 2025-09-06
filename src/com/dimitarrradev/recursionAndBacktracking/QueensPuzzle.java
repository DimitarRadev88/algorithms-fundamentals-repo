package com.dimitarrradev.recursionAndBacktracking;

public class QueensPuzzle {

    private static char[][] BOARD = new char[8][8];

    public static void main(String[] args) {


        for (int i = 0; i < 8; i++) {
            BOARD[i] = new char[] {'-', '-', '-', '-', '-', '-', '-', '-'};
        }

        findQueens(0);

    }

    private static void findQueens(int row) {
        if (row == 8) {
            printBoard();
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (canPutQueen(row, i)) {
                BOARD[row][i] = '*';
                findQueens(row + 1);
            }
            BOARD[row][i] = '-';
        }

    }

    private static boolean canPutQueen(int row, int col) {
        for (int r = 0; r < 8 ; r++) {
            if (BOARD[r][col] == '*') {
                return false;
            }
        }

        for (int c = 0; c < 8 ; c++) {
            if (BOARD[row][c] == '*') {
                return false;
            }
        }

        for (int r = row, c = col; r < 8 && c < 8; r++, c++) {
            if (BOARD[r][c] == '*') {
                return false;
            }
        }


        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (BOARD[r][c] == '*') {
                return false;
            }
        }


        for (int r = row, c = col; r >= 0 && c < 8; r--, c++) {
            if (BOARD[r][c] == '*') {
                return false;
            }
        }


        for (int r = row, c = col; r < 8 && c >= 0; r++, c--) {
            if (BOARD[r][c] == '*') {
                return false;
            }
        }

        return true;
    }

    private static void printBoard() {
        for (char[] chars : BOARD) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
