package Heap;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        // init heap 'the less frequent element first'
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> frequency.get(a) - frequency.get(b));
        
        for (int num : frequency.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        int[] result = new int[k];
        while (k-- > 0) {
            result[k] = minHeap.remove();
        }
        
        return result;
    }
}