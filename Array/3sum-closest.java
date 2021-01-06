import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        // this is just a default to compare the rest of triplets against
        int result = nums[0] + nums[1] + nums[nums.length - 1];
     
        for (int i = 0; i < nums.length - 2; i++) {
            
                int low = i + 1;
                int high = nums.length - 1;
                
                while (low < high) {
                    
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                    
                    // if sum of current triplet is less than what we have so far, update the result
                    if (Math.abs(target - sum) < Math.abs(target - result)) {
                        result = sum;
                    }
                } // while
            } // for
        return result;
    }
}
