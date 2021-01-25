package BinarySearch;

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            
            int mid = left + (right - left) / 2;
            
            // on ascending part, peak must be on the right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // when left == right the peak is found
        return left;  
    }
}