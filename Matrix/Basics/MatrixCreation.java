/*
============================================================
Problem: Print a 2D Matrix

Description:
Given a 2D matrix, print all its elements in row-wise order.

A 2D matrix consists of rows and columns.
We use nested loops to access and print each element.

Concept:
- Outer loop traverses the rows.
- Inner loop traverses the columns.
- Print each element followed by a space.
- After printing each row, move to the next line.

============================================================
Approach 1: Using a Predefined Matrix

- Initialize a matrix with predefined values.
- Use nested loops to traverse and print the elements.

Time Complexity: O(rows * cols)
Space Complexity: O(1) auxiliary space
============================================================
*/

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/*
============================================================
Approach 2: User Input Matrix

- Read the number of rows and columns.
- Create a matrix of the specified dimensions.
- Use nested loops to read each element from the user.
- Use another set of nested loops to print the matrix.

Time Complexity: O(rows * cols)
Space Complexity: O(rows * cols)
============================================================
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Input
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}