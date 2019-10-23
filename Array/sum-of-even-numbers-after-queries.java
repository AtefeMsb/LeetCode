class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        
        int[] afterQueries = new int[A.length];
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int value = query[0];
            int index = query[1];
            
            A[index] = A[index] + value;
            
            // calculate sum of evens
            int evenSum = calculateSumEvenValues(A);
            afterQueries[i] = evenSum;
        }
        
        return afterQueries;
    }
    
    public int calculateSumEvenValues(int[] A) {
        int evenSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evenSum += A[i];
            }
        }
        return evenSum;
    }
}
