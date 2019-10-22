// in-place algorithm
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int line = 0; // the left side of line index are all even numbers
        for (int i = 0; i < A.length; i++) {
            
            // even number
            if (A[i] % 2 == 0) {
            // swap
            int tmp = A[i];
            A[i] = A[line];
            A[line] = tmp;
            
            line++;
            }
        }  
        
        return A;
    }
}
