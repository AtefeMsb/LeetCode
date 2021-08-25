/**
*  Binary Search Template II
* Template #2 is an advanced form of Binary Search. It is used to search for an element or
* condition which requires accessing the current index and its immediate right neighbor's index in the array.
*/
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if still in increasing part of array
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            // if is not increasing
            } else {
                right = mid;
            }
        }
                               
        return left; 
    }
}