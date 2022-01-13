package Array;

public class ContainsDuplicate3 {
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        // Self-balancing Binary Search Tree 
        // Long is needed for avoiding integer overflow
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Find the successor of current element
            Long bigger = set.ceiling((long) nums[i]);
            if (bigger != null && bigger - nums[i] <= t) {
                return true;
            }

            // Find the predecessor of current element
            Long smaller = set.floor((long) nums[i]);
            if (smaller != null && nums[i] - smaller <= t) {
                return true;
            }

            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
        
    }
}

// --------------------------------------------------------------
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            
            Integer bigger = set.ceiling(nums[i]);
            if (bigger != null && bigger <= (long) nums[i] + t) return true;
            
            Integer smaller = set.floor(nums[i]);
            if (smaller != null && nums[i] <= (long) smaller + t) return true;
            
            set.add(nums[i]);
            
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
   
        }
        
        return false;
    }
}