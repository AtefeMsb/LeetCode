/**
 * Binary Search Template II
 * Template #2 is an advanced form of Binary Search. It is used to search for an element or
 * condition which requires accessing the current index and its immediate right neighbor's index in the array.
 * time: O(logn)
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int left = 1;
        int right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
        
    }
}