// NEETCODE solution
class Solution {
  public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      
      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (nums[mid] == target) {
              return mid;
          }
          
          // if in left sorted part
          if (nums[mid] >= nums[left]) {
              
              if (target > nums[mid]) {
                  left = mid + 1;
              } else if (target < nums[left]) {
                  left = mid + 1;
              } else {
                  right = mid - 1;
              }
              
          // if in right sorted part
          } else {
              
              if (target < nums[mid]) {
                  right = mid - 1;
              } else if (target > nums[right]) {
                  right = mid - 1;
              } else {
                  left = mid + 1;
              }
              
          }
      }
      
      return -1;
  }
}

// --------------------------
// nick white solution
/*
step 1- find the pivot point
step 2- perform regular binary search
*/

class Solution {
  public int search(int[] nums, int target) {
      if (nums == null || nums.length == 0) return -1;
      
      // find the pivot, the minimum number
      int left = 0;
      int right = nums.length - 1;
      
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (nums[mid] > nums[right]) {
              left = mid + 1;
          } else {
              right = mid;
          } 
      }
      
      int start = left;
      left = 0;
      right = nums.length - 1;
      
      if (target >= nums[start] && target <= nums[right]) {
          left = start;
      } else {
          right = start;
      }
      
      // do binary search
      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (target == nums[mid]) {
              return mid;
          } else if (target < nums[mid]) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      
      return -1;
  }
}