class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int oneCount = 0;
        int flipCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '0') {
                
                if (oneCount == 0) {
                    continue;
                } else {
                   flipCount++; 
                }  
                
            } else if (c == '1') {
                
                oneCount++;
                
            }  
            
             if (flipCount > oneCount) {
                flipCount = oneCount;
            }
            
        }
        
        return flipCount;
    }
}
// ------------------------------------------
class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int oneCount = 0;
        int flipCount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '0') {
                flipCount++;
            }
            
            if (c == '1') {
                oneCount++;
            }
            
            flipCount = Math.min(flipCount, oneCount);
        }
        
        return flipCount;
        
    }
}