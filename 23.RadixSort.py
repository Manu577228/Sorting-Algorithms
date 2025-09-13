# Radix Sort is a non-comparative integer sorting algorithm that sorts data with 
# integer keys by grouping keys by individual digits (from least significant to most significant).
# It uses a stable sub-sorting algorithm like Counting Sort for each digit place.

# Explanation

# Radix Sort works digit by digit, starting from the least significant digit (LSD) to the most significant digit (MSD).

# For each digit position, it uses a stable sort (like counting sort) to order elements according to that digit.

# After processing all digits, the array becomes completely sorted.

# Time Complexity: O(d × (n + k)), where

# d = number of digits in the largest number

# n = number of elements

# k = range of digits (usually 0–9 for decimal numbers)

def counting_sort(arr, exp):
    n = len(arr)
    output = [0] * n
    count = [0] * 10

    for i in range(n):
        index = (arr[i] // exp) % 10
        count[index] += 1;

    for i in range(1, 10):
        count[i] += count[i - 1]

    for i in range(n - 1, -1, -1):
        index = (arr[i] // exp) % 10
        output[count[index] - 1] = arr[i]
        count[index] -= 1

    for i in range(n):
        arr[i] = output[i]

def radix_sort(arr):
    max_num = max(arr)

    exp = 1

    while max_num // exp > 0:
        counting_sort(arr, exp)
        exp *= 10

nums = [170, 45, 75, 90, 802, 24, 2, 66]

print("Original:", nums)
radix_sort(nums)
print("Sorted:", nums)

