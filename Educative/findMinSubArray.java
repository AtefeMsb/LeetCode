/*
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous
subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
sliding window
O(n)
*/

class MinSizeSubArraySum {
    public static int findMinSubArray(int target, int[] arr) {
  
      int res = Integer.MAX_VALUE;
      int left = 0;
      int right = 0;
      int sum = 0;
  
      for (right = 0; right < arr.length; right++) {
        sum += arr[right];
  
        // while still sum is valid, shrink the window from left
        while (sum >= target) {
          res = Math.min(res, right - left + 1);
          sum -= arr[left];
          left++;
        }
  
      }
  
      return (res == Integer.MIN_VALUE) ? 0 : res;
    }
  
    public static void main(String[] args) {
      int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
      System.out.println("Smallest subarray length: " + result);
      result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
      System.out.println("Smallest subarray length: " + result);
      result = findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
      System.out.println("Smallest subarray length: " + result);
    }
  }
  