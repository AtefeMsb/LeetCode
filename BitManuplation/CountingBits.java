class Solution {
    public int[] countBits(int n) {
        
        int[] result = new int[n + 1];
        
        // count the number of 1s at each number in the range of 0 to n
        for (int i = 0; i < n + 1; i++) {
            int count = 0;
            int mask = 1;
            for (int j = 0; j < 32; j++) {
                if ((i & mask) != 0) {
                    count++;
                }
                mask = mask << 1;
            }
            
            result[i] = count;
        }
        
        return result;
    }
}