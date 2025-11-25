// import java.util.Scanner;

// public class RemoveDuplicatesSortedArray {
//     public static int removeDuplicates(int[] arr, int n) {
//         if (n == 0) return 0;

//         int uniqueIndex = 0; // Pointer for the last unique element
//         for (int i = 1; i < n; i++) {
//             if (arr[i] != arr[uniqueIndex]) {
//                 uniqueIndex++; // Move pointer forward
//                 arr[uniqueIndex] = arr[i]; // Store unique element
//             }
//         }
//         return uniqueIndex + 1; // Return the count of unique elements
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Read size of array
//         int n = sc.nextInt();
//         int[] arr = new int[n];

//         // Read array elements
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }
//         sc.close();

//         // Remove duplicates
//         int newLength = removeDuplicates(arr, n);

//         // Print unique elements
//         for (int i = 0; i < newLength; i++) {
//             System.out.print(arr[i] + " ");
//         }
//     }
// }
import java.util.Scanner;

public class LeadersInArray {
    public static void findLeaders(int[] arr, int n) {
        int maxFromRight = arr[n - 1]; // Rightmost element is always a leader
        System.out.print("Elements with no greater element to right: " + maxFromRight);

        // Traverse from second-last element to first
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i]; // Update maxFromRight
                System.out.print(" " + maxFromRight);
            }
        }
        System.out.println(); // New line for output formatting
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Find and print leader elements
        findLeaders(arr, n);
    }
}

