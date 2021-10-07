/**
 * bruth force
 * time: O(n ^ 2)
 */
class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        // i is left pointer
        for (int i = 0; i < height.length; i++) {
            // j is the right pointer
            for (int j =  i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(area, max);
            }
        }
        
        return max;
    }
}
// ---------------------------------------------------------
/**
 * two pointers
 * time: O(n)
 */
class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(area, max);
            
            // always move the shortest pointer
            // because moving each pointers decrese the width anyway
            // and if we move the tallest, only will decrese it
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
        
    }
}
