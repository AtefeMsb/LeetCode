// Lexicographically next permutation algorithm
// 1. find an index i that after that the whole array is strictly decreasing
// 2. in the decresing part find the first bigger item that element in index i and SWAP
// 3. reverse the section of array after index i
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // look for strictly decresing i index. ex: 6-2-1-5-4-3-0 --> 5-4-3-0 is decresing
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        // if i == 0, it means the whole array is decreasing, so we only need to reverse it
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

