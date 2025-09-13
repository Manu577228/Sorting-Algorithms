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
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio      */
/* -----------------------------------------------------------------------  */

import java.io.*;
import java.util.*;

public class Main {
    static int[] countingSort(int[] arr) {
        // Step 1: Find max element
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // Step 2: Create and fill count array
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Step 3: Build sorted array from count
        int[] sorted = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sorted[idx++] = i;
                count[i]--;
            }
        }

        return sorted;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int[] res = countingSort(arr);

        PrintWriter out = new PrintWriter(System.out);
        out.print("Sorted Array: ");
        for (int i = 0; i < res.length; i++) {
            out.print(res[i] + " ");
        }
        out.println();
        out.flush();
    }
}
