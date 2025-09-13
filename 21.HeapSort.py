# Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. 
# It repeatedly extracts the maximum (or minimum) element from the heap and places 
# it at the end of the array, resulting in a sorted sequence.

# Explanation

# First, we build a max heap from the input array.

# The largest element (root of the heap) is swapped with the last element of the array.

# We reduce the heap size by 1 and heapify the root element again.

# Repeat steps 2–3 until all elements are sorted.

# Heap Sort runs in O(n log n) time and does not require extra space beyond the input array (in-place sorting).

def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[largest]:
        largest = left

    if right < n and arr[right] > arr[largest]:
        largest = right

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heap_sort(arr):
    n = len(arr)

    for i in range(n // 2 -1, -1, -1):
        heapify(arr, n, i)

    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)

arr = [12, 11, 13, 5, 6, 7]
print("Original array:", arr)

heap_sort(arr)

print("Sorted array:", arr)

