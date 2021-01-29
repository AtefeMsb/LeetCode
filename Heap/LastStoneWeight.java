package Heap;

// use MaxHeap: in java use PriorityQueue o create heaps
class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        
        // define a maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        /** OR define the heap this way
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder()); */

        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        // remove 2 largest element if there are more than 1 item left in the heap
        while (maxHeap.size() > 1) {
            int s1 = maxHeap.remove();
            int s2 = maxHeap.remove();
            
            // if stones are diffrent weight, there will be leftover after crash
            if (s1 != s2) {
                maxHeap.add(s1 - s2);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }
}