class Solution {
    public int searchInsert(int[] nums, int target) {
           
        int low = 0; 
        int high = nums.length - 1;
        int mid = 0;
        
        // using binary search to find the location
       while (low <= high) {
           // round down
            mid = low + ((high - low) / 2);
            System.out.println("mid " + mid);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
       }
      
      // in case element was not in the array, low location would be its spot.
        return low;
        
    }
}
