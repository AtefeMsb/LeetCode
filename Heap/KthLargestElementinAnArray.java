package Heap;

/**
Logic:
Why use min heap:
while constructing the minheap we keep the size under k, each time throwing out the SMALLEST item
or the ROOT of the heap, at the end there will be a heap with the kth largest element at its root
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        return minHeap.remove();
    }
}