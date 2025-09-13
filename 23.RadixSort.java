/* ----------------------------------------------------------------------------  */
/*   ( The Authentic JS/JAVA CodeBuff )
 ___ _                      _              _ 
 | _ ) |_  __ _ _ _ __ _ __| |_ __ ____ _ (_)
 | _ \ ' \/ _` | '_/ _` / _` \ V  V / _` || |
 |___/_||_\__,_|_| \__,_\__,_|\_/\_/\__,_|/ |
                                        |__/ 
 */
/* --------------------------------------------------------------------------   */
/*    Youtube: https://youtube.com/@code-with-Bharadwaj                        */
/*    Github : https://github.com/Manu577228                                  */
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio        */
/* -----------------------------------------------------------------------  */

import java.io.*;

public class RadixSortDemo {

    // Counting Sort for a given digit (exp = 1, 10, 100,...)
    static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];     // Step 1: Temporary output array
        int[] count = new int[10];     // Step 2: Count array for digits 0-9

        // Step 3: Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10;
            count[index]++;
        }

        // Step 4: Convert count to cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Build the output array (stable - from end)
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        // Step 6: Copy sorted output back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Main Radix Sort
    static void radixSort(int[] arr) {
        // Step 7: Find max to know number of digits
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // Step 8: Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.print("Original: ");
        for (int x : nums) System.out.print(x + " ");
        System.out.println();

        radixSort(nums);

        System.out.print("Sorted: ");
        for (int x : nums) System.out.print(x + " ");
        System.out.println();
    }
}
