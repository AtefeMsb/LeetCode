/**
* Monotonically Decresing Queue
* time: O(n)
* space: O(n)
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        
        // contains index
        Deque<Integer> deque = new ArrayDeque<>();
        
        while (right < nums.length) {
            // remove smaller values from the end/right of deque
            // while queue is not empty and the right most value in the queue is less than the nums[right]
            // we are inserting, remove values from last. we can only add smaller values! (Monotonically Decresing Queue)
            while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
                deque.removeLast();    
            }
            
            deque.addLast(right);
            
            // if most left value in deque is out of bound, remove it from window
            if (left > deque.peekFirst()) {
                deque.removeFirst();
            }
            
            // if the window is at least size k, add the left most value to result
            if (right - left + 1 >= k) {
                result.add(nums[deque.peekFirst()]);
                // shift window by one position
                left++;
            }
            
            right++;
            
        }
     
        int[] intArray = result.stream().mapToInt(i->i).toArray();
        return intArray;
    }
}