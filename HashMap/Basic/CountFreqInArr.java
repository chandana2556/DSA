/*
============================================================
Problem: Count Frequencies in an Array

Description:
Given an array of integers, count how many times each
element appears using a HashMap.

For every element:
- If the element is not present, its frequency starts from 0.
- Increase its frequency by 1.
- Finally, print the HashMap containing each element
  and its frequency.

Time Complexity: O(n)
Space Complexity: O(n)
============================================================
*/

import java.util.*;

public class Main {

    static void countFreq(int[] arr) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        System.out.println(freq);
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

        countFreq(arr);

        sc.close();
    }
}