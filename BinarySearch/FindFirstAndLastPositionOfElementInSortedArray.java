class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = modifiedBinarySearch(nums, target, true);
        int right = modifiedBinarySearch(nums, target, false);
        return new int[]{left, right};
    }
    
    public int modifiedBinarySearch(int[] nums, int target, boolean leftBias) {
        
        int left = 0;
        int right = nums.length - 1;
        int i = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                i = mid;
                if (leftBias == true) right = mid - 1;
                if (leftBias == false) left = mid + 1;
            }
        }
        
        return i;
        
    }
}