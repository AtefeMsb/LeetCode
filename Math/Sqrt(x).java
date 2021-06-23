/**
* Binary Search
* time: O(logn)
* space: O(1)
*/

class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        
        // sqrt(x) is an integer between 1 to x/2
        int left = 2;
        int right = x / 2;
        int mid = 0;
        long num;
        
        while (left <= right) {
            
            mid = left + (right - left) / 2;
            num = (long) mid * mid;
            
            if (num == x) {
                return mid;
            } else if (num < x) {
                left = mid + 1;
            } else if (num > x) {
                right = mid - 1;
            }
            
        }
        
        // why right ? Because, you want when you exit the while loop, you must have left > right,
        // you want to return the smaller integer, which is right.
        return right;
    }
}