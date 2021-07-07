/** using 2 auxiliary array to keep product to the left and the right
 * time: O(n)
 * space: O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        
        leftProducts[0] = 1;
        rightProducts[n - 1] = 1;
        
        for (int i = 1; i < n ; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }
        
         for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }
        
        return result;
    }
}

/** 
 * using no extra space
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
              
        // use result array instead of leftProduct array
        result[0] = 1;
        for (int i = 1; i < n ; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        
        // use only one variable to keep the esult of right products
        int r = 1;
         for (int i = n - 1; i >= 0; i--) {
             
            result[i] = result[i] * r;
             r = r * nums[i];
             
        }
        
        return result;
    }
}