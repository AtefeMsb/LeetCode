class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        
        int[] res = new int[length];
        
        for (int[] update : updates) {
            
            int start = update[0];
            int end = update[1];
            int val = update[2];
            
            // only update the first index
            res[start] += val;
            
            // no need to update the last index or anything after
            // stop the update by removing the same amount from future indices
            if (end < length - 1) {
                res[end + 1] -= val;
            }
            
        }
        
        
        // calculate prefix sum
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        
        return res;
    }
}