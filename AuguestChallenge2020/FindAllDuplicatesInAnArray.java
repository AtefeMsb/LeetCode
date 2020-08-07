package AuguestChallenge2020;

import java.util.ArrayList;
import java.util.List;

/* SOLUTION ONE - 2 LOOPS
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        // If the value at index abs(x)-1 is positive, it must have been negated twice. Thus abs(x) must have appeared twice in the array. We add abs(x) to the result.
        for (int num : nums) {
            nums[Math.abs(num) - 1] *= -1;
        }

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                ans.add(Math.abs(num));
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        return ans;
    }
}

*/

// SOLUTION 2 - 1 PASS
/*
Notice that if an element x occurs just once in the array, the value at index abs(x)-1 becomes negative and remains so for all of the iterations that follow.

Traverse through the array. When we see an element x for the first time, we'll negate the value at index abs(x)-1.
But, the next time we see an element x, we don't need to negate again! If the value at index abs(x)-1 is already negative, we know that we've seen element x before.
*/
class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) { // seen before
                ans.add(Math.abs(num));
            }
            nums[Math.abs(num) - 1] *= -1;
        }

        return ans;
    }
}