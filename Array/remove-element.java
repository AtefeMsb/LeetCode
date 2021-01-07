
// Approach 1: Two Pointers
class Solution {
    public int removeElement(int[] nums, int val) {
        
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        return slow;
    }
}


// Approach 2: Two Pointers - when elements to remove are rare
class Solution2 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else{
                i++;
            }
        }
        
        return n;
    }
}
