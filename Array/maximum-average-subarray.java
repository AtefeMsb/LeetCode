// cumulative sum
/*public class Solution {
	public double findMaxAverage(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
		    sum[i] = sum[i - 1] + nums[i];
        }
        
		double res = sum[k - 1] * 1.0 / k;
        
		for (int i = k; i < nums.length; i++) {
			res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
		}
        
		return res;
	}
}
*/

// sliding window
// instead of creating a sum array like last solution
// first calculate sum of first k number
// then move this winsow by adding the new emenet to the sum and subtracting the first element
// continusuly update the result to the max
public class Solution {
	public double findMaxAverage(int[] nums, int k) {
        
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum+= nums[i];
        }
        
        int result = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            result = Math.max(sum, result);
        }
        
        return result * 1.0 / k;
    }
}
