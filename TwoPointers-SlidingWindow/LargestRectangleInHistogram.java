/**
 * approach 1
 * time: O(n ^ 2)
 * space: o(1)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int result = 0;
        int n = heights.length;
            
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (j - i + 1);
                result = Math.max(result, area);
            }
        }
        
        return result;
    }
}
// ------------------------------------------------------------------------
/**
 * 
 */