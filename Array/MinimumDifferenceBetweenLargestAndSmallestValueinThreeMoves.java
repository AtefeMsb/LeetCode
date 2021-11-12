/**
 * 4 smallest number: s1 s2 s3 s4
 * 4 largest number:  l1 l2 l3 l4
 * 
 * 4 senario:
 * 1. l4 - s4 (remove 3 smallest number or convert them into s4)
 * 2. l3 - s3 (remove 2 smallest number and 1 large number)
 * 3. l2 - s2
 * 4. l1 - s1
 */
class Solution {
    public int minDifference(int[] nums) {
        // edge case
        if (nums.length < 5) {
            return 0;
        }
        
        // find the 4 largest number
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // find the 4 smallest number
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        
        for (int num : nums) {
            minHeap.add(num);
            maxHeap.add(num);
            
            if (minHeap.size() > 4) {
                minHeap.remove();
                maxHeap.remove();
            }
        }
        
        // sorted in increasing order
        List<Integer> largest = new ArrayList<>();
        List<Integer> smallest = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            largest.add(0, minHeap.remove());
            smallest.add(maxHeap.remove());
        }
       
        // calculate the 4 diffrent combination between largest and smallest
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(minDiff, largest.get(i) - smallest.get(i));
        }
        
        return minDiff;
    }
}