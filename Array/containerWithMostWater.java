/**
 * bruth force using left and right pointer
 * time: O(n ^ 2)
 * space: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        // a for loop for left pointer
        for (int i = 0; i < height.length; i++) {
            // a for loop for right pointer
            for (int j = i + 1; j < height.length; j++) {
                // current area
                int area = Math.min(height[i], height[j]) * (j - i);
                // update the max area
                max = Math.max(max, area);
            }   
        }
        return max;
    }
}
// ----------------------------------------
/**
 * two pointer
 * time: O(n)
 * space: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        // intialize left and right pointer to extreme of the array
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            
            // always move the shorter height, because moving taller would never increase the area!!! 
            if (height[left] < height[right]) {
                left++;
            } else{
                right--;
            }
        }
        
        return max;   
    }
}