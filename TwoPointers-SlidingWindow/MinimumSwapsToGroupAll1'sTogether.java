class Solution {
    public int minSwaps(int[] data) {
        
        // count number of ones in data
        int windowSize = 0;
        for (int d : data) {
            windowSize += d;
        }
        
        // keet the max amount of ones in a window
        int maximumOnes = 0;
        int currentOnes = 0;
        
        int left = 0;
        
        // exxpand the window
        for (int right = 0; right < data.length; right++) {
            
            currentOnes += data[right];
            
            // shrink the window
            // the valid window size is less than "count of ones"
            if (right - left + 1 > windowSize) {
                currentOnes -= data[left];
                left++;
            }
            
            maximumOnes = Math.max(maximumOnes, currentOnes);
            
        }
        
        return windowSize - maximumOnes;
        
    }
}