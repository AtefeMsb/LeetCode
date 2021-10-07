package TwoPointers;
/**
 * Time complexity : O(n)
 * Space complexity : O(1)
 * Floyd's Tortoise and Hare (Cycle Detection)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        
        // find the intersection
        int slow = 0;
        int fast = 0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        int intersection = slow;
        
        // find the begiing of the cycle
        int p1 = 0;
        int p2 = intersection;
        
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        
        return p1;  
    }
}

