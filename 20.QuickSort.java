/* ----------------------------------------------------------------------------  */
/*   ( The Authentic JS/JAVA CodeBuff )                                         */
/*  ___ _                      _              _                                 */
/*  | _ ) |_  __ _ _ _ __ _ __| |_ __ ____ _ (_)                                */
/*  | _ \ ' \/ _` | '_/ _` / _` \ V  V / _` || |                                */
/*  |___/_||_\__,_|_| \__,_\__,_|\_/\_/\__,_|/ |                                */
/*                                     |__/                                     */
/* ----------------------------------------------------------------------------  */
/*    Youtube: https://youtube.com/@code-with-Bharadwaj                         */
/*    Github : https://github.com/Manu577228                                    */
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio         */
/* ----------------------------------------------------------------------------  */

import java.io.*;

public class QuickSortExample {

    // Partition function (Lomuto partition scheme)
    static int partition(int[] a, int low, int high) {
        int pivot = a[high];                  // choose last element as pivot
        int i = low - 1;                      // i will track position of smaller elements
        for (int j = low; j < high; j++) {    // iterate from low to high-1
            if (a[j] <= pivot) {              // if current element <= pivot, place in left side
                i++;
                int temp = a[i];              // swap a[i] and a[j]
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];                  // place pivot after last smaller element
        a[i + 1] = a[high];
        a[high] = temp;
        return i + 1;                         // return pivot index
    }

    // QuickSort recursive function
    static void quicksort(int[] a, int low, int high) {
        if (low < high) {                     // base case: at least two elements
            int p = partition(a, low, high);  // partition the array and get pivot index
            quicksort(a, low, p - 1);         // recursively sort left partition
            quicksort(a, p + 1, high);        // recursively sort right partition
        }
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};   // initial unsorted list

        System.out.print("Original array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();

        quicksort(arr, 0, arr.length - 1);    // call quicksort

        System.out.print("Sorted array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
    }
}
