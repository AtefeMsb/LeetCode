class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        if (nums == null || nums.length < 1) { return 0; }
 
        // length of the max of all
        int max = 1;
        // length of the current subsequence
        int maxSoFar = 1;
        
        // check each item and if it is bigger than the item before 
        // add one to maxSoFar and update max if necessary 
        // otherwise start a new subsequence - start counting from 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                maxSoFar = maxSoFar + 1;
                max = Math.max(maxSoFar, max);
            } else {
                maxSoFar = 1;
            }
        }
        
        return max;
    }
}
