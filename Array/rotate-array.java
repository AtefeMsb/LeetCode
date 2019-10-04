class Solution {
    public void rotate(int[] nums, int k) {
        
        // reverse the whole list
        // reverse the first k
        // reverse the rest
        
        k = k % nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
   
    }
    
    public void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            end--;
            start++;
        }
    }
}
