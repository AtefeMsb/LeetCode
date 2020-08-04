package TopInterview;

public class StringToInteger {
    public int myAtoi(String str) {
    
        StringBuilder resultStr = new StringBuilder(); 
        boolean negative = false;
        
        
        if (str == null || str.isEmpty()) return 0;
        
        // checks for the first  non-space character
        int i = 0;
        
        while (i < str.length() && (str.charAt(i) == ' ')) {
            i++;
        }
        
        if (i >= str.length()) {
            return 0;   
        }
        
        Character firstChar = str.charAt(i);
        
        if (firstChar == '-') {
            negative = true;
            i++;
        } else if (firstChar == '+') {
            i++;
        } else if (!Character.isDigit(firstChar)) {
            return 0;
        }
        
        if (i >= str.length()) {
            return 0;   
        }
        
        while (i < str.length() && (str.charAt(i) == '0')) {
            i++;
        }
        
        
        while (i < str.length()) {
            Character current = str.charAt(i);
            if (Character.isDigit(current)) {
                resultStr.append(current);
                i++;
            } else{
                break;
            }
        }
        
        
        if (resultStr.length() > 11) {
            return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
        }
        
        if (resultStr.length() == 0 ){
            return 0;
        }
        
        
        long resultLong = Long.parseLong(resultStr.toString());
            
        if (negative) {
            resultLong *= -1;
        }
        
        if (negative && resultLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (resultLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } 
        
        return (int)resultLong;    
    }
    
}