/**
 * time: O(n)
 * space: O(n)
 */
class Solution {
    public int trap(int[] height) {
        
        int result = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Find maximum height of bar from the left end upto an index i
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        rightMax[n - 1] = height[n - 1];
        // Find maximum height of bar from the right end upto an index i
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
            
        // ignore the first and the last element
        for (int k = 1; k < n - 1; k++) {
            result += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        
        return result;
    }
}

/**
 * 2 pointer
 * time: O(n)
 * space: O(1)
 */
class Solution { 
    public int trap(int[] height) {

            // edge case
            if (height.length == 0) return 0; 

            int left = 0;
            int right = height.length-1; 
        
            int leftMax = height[left];
            int rightMax = height[right]; 

            int ans = 0; 
            while (left < right) {

                if (leftMax < rightMax) {
                    left++; 
                    leftMax = Math.max(leftMax, height[left]);
                    ans += leftMax - height[left];
                } else {
                    right--; 
                    rightMax = Math.max(rightMax, height[right]);
                    ans += rightMax - height[right];
                }
            }

            return ans; 
    }
}
