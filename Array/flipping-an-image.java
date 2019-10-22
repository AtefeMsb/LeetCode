class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        // flip horizontally
        for (int i = 0; i < A.length; i++) {
              
            int s = 0;
            int e = A[i].length - 1;
            
            while (s < e) {
                int temp = A[i][e];
                A[i][e] = A[i][s];
                A[i][s] = temp;
                s++;
                e--;
            }
                
            }
            
            // invert it
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 0){
                    A[i][j] = 1;
                }else if (A[i][j] == 1){
                    A[i][j] = 0;
                }
             }
        }
        
        
        return A;
    }
}
