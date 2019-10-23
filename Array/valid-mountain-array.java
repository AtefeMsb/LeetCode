class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        
        int n = A.length;
        int i = 0;
        // walk up
        while (i < n - 1 && A[i] < A[i + 1]) {
            i++;
        }
        
           // make sure peak is not at the END or BEGINING of the array
        if (i == 0 || i == n - 1) {
            return false;
        }
        
        // walk down
        while (i < n - 1 && A[i] > A[i + 1]) {
            i++;
        }
        
        return i == n - 1;    
    }
}
