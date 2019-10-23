// two pointers
class Solution {
    public int[] sortedSquares(int[] A) {
        
        int n = A.length;
        int[] squares = new int[n];
        int index = 0;
        
        // found first positive >= 0
        int pos  = 0;
        while (pos < n && A[pos] < 0) {
            pos++;
        }
        
        int left = pos - 1;
        int right = pos;
        
        while (left >= 0 && right < n) {
       
            int absLeft = Math.abs(A[left]);
            int absRight = Math.abs(A[right]);                      
            if (absLeft < absRight) {
                squares[index] = absLeft * absLeft;
                left--;
                index++;
            } else {
                squares[index] = absRight * absRight;
                right++;
                index++;
            }
        }
        
            // in case there are some items left in right side
            while (right < n) {
                int absRight = Math.abs(A[right]);
                squares[index] = absRight * absRight;  
                right++;
                index++;
                continue;
            }
 
            // in case there are some items left in left side
            while (left >= 0) {
                int absLeft = Math.abs(A[left]);
                squares[index] = absLeft * absLeft;
                left--;
                index++;
                continue;
            }
        
        return squares;  
    }
}
