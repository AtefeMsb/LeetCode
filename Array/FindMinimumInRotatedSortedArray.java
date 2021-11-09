/**
 * binary search in rotated sorted array 
 * time: O(n)
 */
class Solution {
    public int findMin(int[] nums) {
        
        int min = nums[0];
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            // if the whole portion is sorted [left, right]
            if (nums[left] < nums[right]) {
                // get the first and smallest item
                min = Math.min(min, nums[left]);
                break;
            }
            
            // binary search
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            
            // left sorted portion
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            // right sorted portion
            } else {
                right = mid - 1;
            }
           
        }
        
        return min;
        
    }
}