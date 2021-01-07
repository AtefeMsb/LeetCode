class Solution {
    public void duplicateZeros(int[] arr) {
        
        int dupsCount = 0;
        int length = arr.length - 1;
       
        // count number of zero elements
        for (int i = 0; i <= length - dupsCount; i++) {
            
            if (arr[i] == 0) {
                
                //  EDGE CASE for counting zero: if zero be the last element
                //  and there is no space to duplicate it
                if (i == length - dupsCount) {
                    // For this zero we just copy it without duplication.
                    arr[length] = 0;
                    length--;
                    break;
                }
                
                dupsCount++;
            }
        }
        
        // Start backwards from the last element which would be part of new array.
        int last = length - dupsCount;
        
        // Copy zero twice, and non zero once.
        for (int j = last; j >= 0; j--) {
            if (arr[j] == 0) {
                arr[j + dupsCount] = 0;
                dupsCount--;
                arr[j + dupsCount] = 0;
                
            } else {
                arr[j + dupsCount] = arr[j];
            }
        }
        
    }
}