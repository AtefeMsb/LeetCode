// using extra space
class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        int[] temp = new int[n];
        
        for (int i = 0; i < n; i++) {
            int pos = (i + k) % n;
            temp[pos] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
// -------------------------------------------
// no extra space - using reverse
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
