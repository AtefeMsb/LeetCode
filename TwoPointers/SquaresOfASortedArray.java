package TwoPointers;

class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int index = 0;
        int[] sqrs = new int[n];
        
        // find the first positive element
        int pos = 0;
        while (pos < n && nums[pos] < 0) {
            pos++;
        }
        
        // 2 pointers for positive and negative sides of the array
        int left = pos - 1;
        int right = pos;
        
        while (left >= 0 && right < n) {
            int leftSqr = nums[left] * nums[left]; 
            int rightSqr = nums[right] * nums[right];
            
            if (leftSqr < rightSqr) {
                sqrs[index] = leftSqr;
                left--;
                index++;
            } else {
                sqrs[index] = rightSqr;
                right++;
                index++;
            }
        }
        
        // if there is leftover from left side or right side
        while (left >= 0) {
            int leftSqr = nums[left] * nums[left]; 
            sqrs[index] = leftSqr;
            left--;
            index++;
        } 
        
        while (right < n) {
            int rightSqr = nums[right] * nums[right];
            sqrs[index] = rightSqr;
            right++;
            index++;
        }
        
        return sqrs;
    }
}