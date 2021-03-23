package String;

class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
                
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        
        // continue till both of them are finished
        while (p1 >= 0 || p2 >= 0) {
            int digit1 = p1 >= 0 ?  num1.charAt(p1) - '0' : 0;
            int digit2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            int value = sum % 10;
            carry = sum / 10;

            // prepand to the begining of string builder
            sb.insert(0, value);
            
            p1--;
            p2--;
        }
        
        if ( carry != 0) {
            sb.insert(0, carry);
        }
        
        
        return sb.toString();
    }
}