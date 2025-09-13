# Counting Sort is a non-comparison-based sorting algorithm that sorts 
# integers by counting the number of occurrences of each unique value.
# It works efficiently when the range of numbers (max - min) is not significantly larger than the number of elements.

# Explanation

# Counting Sort counts how many times each number appears in the array.

# It stores these counts in a separate array (count[]).

# It then builds the sorted output by placing elements according to their counts.

# It is stable (preserves order of equal elements) and works in O(n + k) time, 
# where n is the number of elements and k is the range of input values.

def counting_sort(arr):
    max_val = max(arr)

    count = [0] * (max_val + 1)

    for num in arr:
        count[num] += 1

    sorted_arr = []
    for i in range(len(count)):
        for _ in range(count[i]):
            sorted_arr.append(i)

    return sorted_arr

nums = [1, 2, 2, 8, 3, 3, 1]
result = counting_sort(nums)

print("Sorted Array:", result)
