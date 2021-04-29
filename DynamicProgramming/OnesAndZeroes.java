/**
 * memoization
 * Time complexity : O(l*m*n)). memo array of size l*m*n is filled, where l is the length of strsstrs, m and nn are the number of zeroes and ones respectively.
 * Space complexity : O(l*m*n). 3D array memo is used.
 */
lass Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] memo = new int[strs.length][m + 1][n + 1];
        return memoization(strs, m, n, 0, memo); 
    }
    
    private int memoization(String[] strs, int zero, int one, int index, int[][][] memo) {
        
         // base case 
        if (index == strs.length) {
            return 0;
        }
        
        // check the memo
        if (memo[index][zero][one] != 0) {
            return memo[index][zero][one];
        }
        
        int[] count = countZeroOne(strs[index]);
        int taken = 0;
        
        // skip this string
        int notTaken = memoization(strs, zero, one, index + 1, memo);
        
        // take this string
        // if the amount of zero and ones in the string do not exceed the requested amount
        if (zero - count[0] >= 0 && one - count[1] >= 0) {
            taken = memoization(strs, zero - count[0], one - count[1], index + 1, memo) + 1;
        }
        
        int result = Math.max(taken, notTaken);
        memo[index][zero][one] = result;
        return result;
    }
    
    // count the number of zeros and ones in the string
    private int[] countZeroOne(String s) {
        int[] result = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') {
                result[0]++;
            } else {
                result[1]++;
            }
        }
        
        return result;
    }
}