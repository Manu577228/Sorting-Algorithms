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

import java.util.*;

public class MergeSortDemo {

    // Merge two sorted arrays into one sorted array
    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length]; // final merged array
        int i = 0;  // pointer for left
        int j = 0;  // pointer for right
        int k = 0;  // pointer for merged

        // compare elements from left and right, copy the smaller into merged
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k] = left[i];  // take from left
                i++;
            } else {
                merged[k] = right[j]; // take from right
                j++;
            }
            k++;
        }

        // copy remaining elements from left, if any
        while (i < left.length) {
            merged[k] = left[i];
            i++;
            k++;
        }

        // copy remaining elements from right, if any
        while (j < right.length) {
            merged[k] = right[j];
            j++;
            k++;
        }

        return merged; // return merged sorted array
    }

    // Merge Sort function
    public static int[] mergeSort(int[] arr) {
        // base case: if array has 0 or 1 elements, it is already sorted
        if (arr.length <= 1) {
            return arr;
        }

        // find mid index to split array into two halves
        int mid = arr.length / 2;

        // create left and right halves
        int[] left = Arrays.copyOfRange(arr, 0, mid); // elements [0..mid-1]
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); // elements [mid..end]

        // recursively sort both halves
        int[] sortedLeft = mergeSort(left);
        int[] sortedRight = mergeSort(right);

        // merge sorted halves
        return merge(sortedLeft, sortedRight);
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};  // original unsorted array
        System.out.println("Original: " + Arrays.toString(arr)); // print original

        int[] sortedArr = mergeSort(arr); // sort array using merge sort

        System.out.println("Sorted:   " + Arrays.toString(sortedArr)); // print sorted
    }
}
