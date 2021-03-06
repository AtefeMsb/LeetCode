/*
keeping max and secondMax, makes it easy to find out if max is bigger than twice all other elements
*/
class Solution {
    public int dominantIndex(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int secondMax =  Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
            
            // System.out.println("max:" + max);
            // System.out.println("secondmax:" + secondMax);
            // System.out.println("index:" + maxIndex);
            // System.out.println("-----------------------------------------");
        }
        
        if (max >= secondMax * 2) {
            return maxIndex;
        } 
        
        return -1;   
    }
}
/////////////////////////////////////////////////////////////
// linear scan
class Solution2 {
    public int dominantIndex(int[] nums) {
        int maxIndex = -1;
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElement) {
                maxIndex = i;
                maxElement = nums[i];
            }
        }
        
        System.out.println("maxIndex "+ maxIndex);
        System.out.println("maxElement "+ maxElement);
        
        for (int num : nums) {
            if (num != maxElement && num * 2 > maxElement) {
                return -1;
            }
        }
        
        return maxIndex;
    }
}