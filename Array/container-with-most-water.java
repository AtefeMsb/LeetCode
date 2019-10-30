// brute force

/*
class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        
        return max;
    }
}
*/

// two-pointers
class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        
        while (l < r) {
            
            // find max area of rectangle
            // maximum area is always limited by the SHORTER height
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
               r--; 
            }
            
        }
        
        return max;
    }
}
