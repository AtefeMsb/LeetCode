class Solution {
    public int countBinarySubstrings(String s) {
        
        int res = 0;
        int prevCount = 0;
        int curCount = 1;
                
        for (int i = 1; i < s.length(); i++) {
            
            // when we reach a diffrent character
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(prevCount, curCount);
                prevCount = curCount;
                curCount = 1;
            } else {
                curCount++;
            }
        }
        
        // last group of characters should get added as well
        res += Math.min(prevCount, curCount);
        
        return res;
         
    }
}