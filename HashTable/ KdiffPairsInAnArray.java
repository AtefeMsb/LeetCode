// bruth force
// O(NlogN) +  O(N^2) ≈ O(N^2)

import java.util.Arrays;

public class Solution {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                if (Math.abs(nums[j] - nums[i]) == k)
                    result++;
            }
        }

        return result;
    }
}
// -------------------------------------------------------------
// O(NlogN)
// two pointers
public class Solution {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        int right = 1;
        int result = 0;

        while (left < nums.length && right < nums.length) {
            // need to make the diffrence larger
            if (left == right || nums[right] - nums[left] < k) {
                right++;  
            // need to make the diffrence smaller
            } else if (nums[right] - nums[left] > k) {
                left++; 
            // found k diffrence
            } else {
                left++;
                result++;
                while (left < nums.length && nums[left] == nums[left - 1])
                    left++;
            }
        }
        return result;
    }
}
// -------------------------------------------------------------
// hashmap
// O(n)
public class Solution {
    public int findPairs(int[] nums, int k) {

        int result = 0;

        HashMap <Integer,Integer> counter = new HashMap<>();
        for (int n: nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }


        for (Map.Entry <Integer, Integer> entry: counter.entrySet()) {
            int x = entry.getKey();
            int val = entry.getValue();
            if (k > 0 && counter.containsKey(x + k)) {
                result++;
            } else if (k == 0 && val > 1) {
                result++;
            }
        }
        return result;
    }
}