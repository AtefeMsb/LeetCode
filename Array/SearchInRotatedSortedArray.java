/**
 * binary search in sorted rotated array
 * time: O(logn)
 */
class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            // target is found
            if (nums[mid] == target) {
                return mid;
            }
            
            // left sorted portion
            if (nums[mid] >= nums[left]) {
                // target is more than middle or less than the smallest left portion
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
              
            // right sorted portion
            } else {
                // target is less than middle or more than largest right left portion
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                
            }
         
        }
        
        return -1;
    }
}