import java.util.Scanner;

/**
 * Console-based Sudoku solver using recursion and backtracking.
 * Enter 0 for an empty cell.
 */
public class SudokuSolver {
    private static final int SIZE = 9;
    private static final int BOX = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[SIZE][SIZE];

        System.out.println("Sudoku Solver (Java - Backtracking)");
        System.out.println("Enter 9 rows, each containing 9 numbers separated by spaces.");
        System.out.println("Use 0 for empty cells.");

        for (int row = 0; row < SIZE; row++) {
            System.out.print("Row " + (row + 1) + ": ");
            for (int col = 0; col < SIZE; col++) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter an integer: ");
                    scanner.next();
                }
                board[row][col] = scanner.nextInt();
                if (board[row][col] < 0 || board[row][col] > 9) {
                    System.out.println("Values must be between 0 and 9. Restart the program.");
                    scanner.close();
                    return;
                }
            }
        }
        scanner.close();

        if (!isInitialBoardValid(board)) {
            System.out.println("The input puzzle contains conflicting values.");
            return;
        }

        System.out.println("\\nInput puzzle:");
        printBoard(board);

        if (solve(board)) {
            System.out.println("\\nSolved puzzle:");
            printBoard(board);
        } else {
            System.out.println("\\nNo solution exists for this puzzle.");
        }
    }

    private static boolean solve(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isSafe(board, row, col, number)) {
                            board[row][col] = number;

                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack: undo the incorrect choice.
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] board, int row, int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }

        int boxStartRow = row - row % BOX;
        int boxStartCol = col - col % BOX;
        for (int r = boxStartRow; r < boxStartRow + BOX; r++) {
            for (int c = boxStartCol; c < boxStartCol + BOX; c++) {
                if (board[r][c] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isInitialBoardValid(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int value = board[row][col];
                if (value != 0) {
                    board[row][col] = 0;
                    boolean valid = isSafe(board, row, col, value);
                    board[row][col] = value;
                    if (!valid) return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            if (row % BOX == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < SIZE; col++) {
                if (col % BOX == 0 && col != 0) System.out.print("| ");
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
