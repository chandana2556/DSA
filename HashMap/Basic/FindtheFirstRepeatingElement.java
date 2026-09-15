/*
============================================================
Problem: Find the First Repeating Element

Description:
Given an array of integers, find the first element that
appears more than once.

Approach:
- Use a HashMap to count the frequency of every element.
- Traverse the original array again from left to right.
- If the frequency of the current element is greater than 1,
  return that element.
- Since we traverse the original array in order, the first
  repeating element is returned.
- If there is no repeating element, return -1.

Time Complexity: O(n)
Space Complexity: O(n)

Example:

Input:
7
4 5 1 2 5 4 8

Output:
First repeating element: 5
============================================================
*/

import java.util.*;

public class Main {

    static int firstRepeating(int[] arr) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Step 2: Traverse original array
        for (int x : arr) {

            if (freq.get(x) > 1) {
                return x;
            }
        }

        // No repeating element
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("First repeating element: " + firstRepeating(arr));

        sc.close();
    }
}

