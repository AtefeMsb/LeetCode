package String;

class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
                
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;
        
        // continue till both of them are finished
        while (p1 >= 0 || p2 >= 0) {
            int digit1 = p1 >= 0 ?  a.charAt(p1) - '0' : 0;
            int digit2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            int value = sum % 2;
            carry = sum / 2;

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