package TwoPointers;

// bruth force
// Time Complexity: O(n^2). We have 2 nested loops.
// Space Complexity: O(1).

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int answer = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k) {
                    answer = Math.max(answer, sum);
                }
            }
        }
        return answer;
    }
}

////////////////////////////////////////////////
// Two Pointers
// Time Complexity: O(nlogn) to sort the array. The two pointers approach itself is O(n), so the time complexity would be linear if the input is sorted.
// Space Complexity: from O(logn) to  O(n), depending on the implementation of the sorting algorithm.
class Solution2 {
    public int twoSumLessThanK(int[] nums, int k) {
        
        Arrays.sort(nums);
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                answer = Math.max(answer, sum);
                left++;
            } else {
                right--;
            }
        }
        
        return answer;
    }
}