/*
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
time: O(n)
sliding window
*/
class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        for (right = 0; right < arr.length; right++) {
            sum += arr[right];

            if (right - left + 1 >= k) {
              max = Math.max(max, sum);
              sum -= arr[left];
              left++;
            }
        }
    
        return max;
    }

    public static void main(String[] args) {
      int result = findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 });
      System.out.println("result: " + result);
    }
}