/*
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) { // even index
                if (A[i] % 2 != 0) { // odd value
                    int c = i + 1;
                    while (c < A.length) {
                        if (A[c] % 2 == 0) {
                            // swap
                            int tmp = A[c];
                            A[c] = A[i];
                            A[i] = tmp;
                            break;
                        }
                        c++;
                    } // while
                }
            } else { // odd index
                if (A[i] % 2 == 0) { // even value
                    int c = i + 1;
                    while (c < A.length) {
                        if (A[c] % 2 != 0) {
                            // swap
                            int tmp = A[c];
                            A[c] = A[i];
                            A[i] = tmp;
                            break;
                        }
                        c++;
                    } // while
                }
                
            }
        }
        
        return A;   
    }
}
*/
// two pointers
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int n = A.length;
        
        while (i < n && j < n) {
            // finds an even index with odd value
            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }
            // find an off index with even value
            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
