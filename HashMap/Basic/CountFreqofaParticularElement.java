/*
============================================================
Problem: Count Frequency of a Particular Element

Description:
Given an array of integers and a target element, find how
many times the target element appears in the array.

Approach:
- Initialize count as 0.
- Traverse through every element of the array.
- If the current element is equal to the target, increment
  the count by 1.
- Finally, print the frequency of the target element.

Time Complexity: O(n)
Space Complexity: O(1)

Example:

Input:
Enter array size:
6
Enter the target:
5
Enter array elements:
2 5 3 5 7 5

Output:
Frequency of 5: 3
============================================================
*/

import java.util.*;

public class Main {

    static void countParticular(int[] arr, int target) {

        int count = 0;

        for (int x : arr) {

            if (x == target) {
                count++;
            }
        }

        System.out.println("Frequency of " + target + ": " + count);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        System.out.println("Enter the target:");
        int target = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        countParticular(arr, target);

        sc.close();
    }
}

Enter array size:
6
Enter the target:
5
Enter array elements:
2 5 3 5 7 5

Frequency of 5: 3