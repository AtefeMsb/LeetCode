package SeptemberChallenge2020;

public class RepeatedSubstringPattern {
    // O(n^2)
    public boolean repeatedSubstringPattern(String s) {
        
        int len = s.length();
        
        // only get substring the size less than half the length of the string
        for (int i = 1; i <= len / 2; i++) {
            
            // if length is divisable by length of substring
            if (len % i == 0) {
                
                int repetitionTimes = len / i;
                
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder(); 
                
                for (int j = 0; j < repetitionTimes; j++) {
                    sb.append(substring);
                }
                
                if (sb.toString().equals(s)) {
                    return true;
                }
         
            }

        }
        
        return false;
    }
}