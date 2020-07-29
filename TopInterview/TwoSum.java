package TopInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 */
public class TwoSum {

    public static int[] twoSum(final int[] nums, final int target) {
       
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            final int diff = target - nums[i];
            if (map.containsKey(diff)) {
                results[0] = i;
                results[1] = map.get(diff);
            } else {
                map.put(nums[i], i);
            }
        }

        return results;  
    }

    public static void main(final String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(twoSum( nums, target));
    }

}
