package BinarySearch;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class SolFirstBadVersionution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            int firstOccurance = n;
            
            while (left <= right) {
                
                int mid = left + (right - left) / 2;
                
                if (isBadVersion(mid)) {
                    firstOccurance = mid;
                    // remove the right half
                    right = mid - 1;
                    
                } else {
                    left = mid + 1;
                }
            }
            
            return firstOccurance;
            
        }
    }