/*
============================================================
Problem: Find the Most Frequent Element

Description:
Given an array of integers, find the element that appears
the maximum number of times.

Approach:
- Use a HashMap to store the frequency of each element.
- Traverse the array and count the frequency of every element.
- Traverse the HashMap using Map.Entry.
- Keep track of the maximum frequency and the corresponding
  element.
- Finally, print the most frequent element.

Time Complexity: O(n)
Space Complexity: O(n)

============================================================
*/
import java.util.*;

public class Main {

    static void countFreq(int[] arr) {

        int maxFreq = 0;
        int answer = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Step 2: Find maximum frequency
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxFreq) {
                maxFreq = value;
                answer = key;
            }
        }

        System.out.println("Most frequent element: " + answer);
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

Enter array size:
7
Enter array elements:
1 2 2 3 1 2 3

Most frequent element: 2