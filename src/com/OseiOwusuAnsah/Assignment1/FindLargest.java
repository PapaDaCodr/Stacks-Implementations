package com.OseiOwusuAnsah.Assignment1;
import java.util.Scanner;

public class FindLargest {
    public static int findLargestValue(int [] arr){
        // Pseudocode:
        // 1. If the array is empty, return 0.
        // 2. Assume the first element is the largest.
        // 3. Iterate through the array starting from the second element.
        // 4. For each element:
        //    If the current element is greater than the current largest,
        //    update the largest.
        // 5. Return the largest element.

        if (arr.length == 0) {
            return 0;
        }

        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;

    }
    public static void main(String[] args) {
        //  take user input using scanner
        // Get the number of elements from the user
        // Create an array of the specified size
        // Read each element from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int largestNumber = findLargestValue(numbers);
        System.out.println("The largest number is: " + largestNumber);

        System.out.println("The time complexity of this algorithm is O(n)," +
                " where n = " +n+" is the number of elements in the array. " );
    }

    }