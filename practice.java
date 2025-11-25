import java.util.*;

class practice{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // size of array
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); // read array elements
        }

        // Step 1: Find the pivot
        int i = n - 2;  // start from second last element
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;  // move left until arr[i] < arr[i+1]
        }

        // Step 2: If pivot exists, find successor and swap
        if(i >= 0){  // pivot found
            int j = n - 1;  // start from last element
            while(arr[j] <= arr[i]){
                j--; // find first element bigger than pivot
            }
            // swap pivot and successor
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Step 3: Reverse the suffix (elements after pivot)
        int start = i + 1;
        int end = n - 1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        // Print result
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
