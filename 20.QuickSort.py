# Quick Sort is an in-place, divide-and-conquer sorting algorithm that picks a 
# pivot and partitions the array so values less than the pivot come before it and values greater come after. 
# It then recursively sorts the left and right partitions until the whole array is sorted.

# Explanation

# Divide and conquer: Quick Sort divides the problem (array) into two subproblems (left and right of the pivot) 
# by partitioning around a pivot element.

# Partition step: Choose a pivot (common simple choice: last element). 
# Rearrange the array so elements ≤ pivot go left, and elements > pivot go right — then place the pivot between them.

# Recursion: Recursively apply quick sort to left and 
# right subarrays (excluding the pivot which is now in correct place).

# Complexity: Average time O(n log n), worst-case O(n²) (when pivot choices 
# are poor, e.g., already sorted input and picking last element), space O(log n) average for recursion stack (O(n) worst-case).

# In-place but not stable: The common in-place Lomuto/Hoare 
# partitions sort without extra arrays but do not preserve relative order of equal elements (not stable).

# Pivot choices & optimizations: Use randomized pivot or 
# median-of-three to avoid worst-case patterns; switch to insertion sort for small subarrays; 
# tail recursion elimination can reduce stack use.

arr = [3, 6, 8, 10, 1, 2, 1];

print("original Array:", arr)

def partition(a, low, high):
    pivot = a[high]
    i = low - 1
    for j in range(low, high):
        if a[j] <= pivot:
            i += 1
            a[i], a[j] = a[j], a[i]
    a[i + 1], a[high] = a[high], a[i + 1]
    return i + 1
    
def quicksort(a, low, high):
    if low < high:
        p = partition(a, low, high)
        quicksort(a, low, p - 1)
        quicksort(a, p + 1, high)

quicksort(arr, 0, len(arr) - 1)

print("Sorted Array: ", arr)

