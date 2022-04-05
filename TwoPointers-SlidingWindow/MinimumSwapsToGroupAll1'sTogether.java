class Solution {
    public int minSwaps(int[] data) {
        
        // count number of ones in data
        int ones = 0;
        for (int d : data) {
            ones += d;
        }
        
        // keet the max amount of ones in a window
        int maximumOnes = 0;
        int currentOnes = 0;
        
        int left = 0;
        int right = 0;
        
        // exxpand the window
        while (right < data.length) {
            
            currentOnes += data[right];
            right++;
            
            // shrink the window
            // the valid window size is less than "count of ones"
            if (right - left > ones) {
                currentOnes -= data[left];
                left++;
            }
            
            maximumOnes = Math.max(maximumOnes, currentOnes);
            
        }
        
        return ones - maximumOnes;
        
    }
}