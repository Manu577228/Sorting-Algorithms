# Merge Sort is a divide-and-conquer, comparison-based sorting algorithm that repeatedly splits the array into halves,
# sorts each half, and then merges the sorted halves.
# It guarantees O(n log n) time in best, average, and worst cases and is a stable sort (preserves equal-element order).

# Explanation

# Idea: Recursively split the list into halves until each piece has 0 or 1 element (already sorted).
# Then merge those small sorted lists back together in order.

# Divide & Conquer: Depth of recursion ≈ log₂(n). Each level performs O(n) work merging → overall O(n log n).

# Space: Typical implementations allocate extra arrays for merging → O(n) additional space (not in-place).

# Stable: If merging uses <= when comparing, elements equal in value retain their relative order.

# Variants: Top-down (recursive) shown here; bottom-up (iterative) is also possible.

def merge(left, right):
    merged = []
    i = 0
    j = 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            merged.append(left[i])
            i += 1
        else:
            merged.append(right[j])
            j += 1

    if i < len(left):
            merged.extend(left[i:])
    if j < len(right):
            merged.extend(right[j:])

    return merged


def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left_half = arr[:mid]
    right_half = arr[mid:]

    sorted_left = merge_sort(left_half)
    sorted_right = merge_sort(right_half)

    return merge(sorted_left, sorted_right)


if __name__ == "__main__":
    arr = [38, 27, 43, 3, 9, 82, 10]
    print("Original:", arr)
    sorted_arr = merge_sort(arr)
    print("Sorted: ", sorted_arr)
