# Java Sudoku Solver

A console-based Sudoku solver implemented in Java using recursion and backtracking.

## Features
- Reads a 9 × 9 Sudoku puzzle from standard input
- Uses `0` to represent empty cells
- Checks row, column and 3 × 3 box constraints
- Uses recursive backtracking to find a solution
- Detects conflicting starting values and puzzles with no solution

## Requirements
- Java JDK 8 or later

## Compile
```bash
javac SudokuSolver.java
```

## Run
```bash
java SudokuSolver
```

Enter 9 rows of 9 integers each, separated by spaces. Use `0` for blanks.

## Sample input
```text
Row 1: 5 3 0 0 7 0 0 0 0
Row 2: 6 0 0 1 9 5 0 0 0
Row 3: 0 9 8 0 0 0 0 6 0
Row 4: 8 0 0 0 6 0 0 0 3
Row 5: 4 0 0 8 0 3 0 0 1
Row 6: 7 0 0 0 2 0 0 0 6
Row 7: 0 6 0 0 0 0 2 8 0
Row 8: 0 0 0 4 1 9 0 0 5
Row 9: 0 0 0 0 8 0 0 7 9
```

## Algorithm
1. Find the next empty cell.
2. Try values from 1 to 9.
3. Check whether a value is valid in its row, column and 3 × 3 box.
4. Place a valid value and recursively solve the remaining board.
5. If a choice leads to a dead end, reset the cell to 0 and try another value.

## Complexity
The backtracking search has an exponential worst-case search space. Constraint checking for each candidate takes constant time because the board size is fixed at 9 × 9.

## Author
Aman Yadav
