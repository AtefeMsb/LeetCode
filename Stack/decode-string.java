public class Solution {
    public String decodeString(String s) {
        
        String res = "";
        Stack<Integer> countStack = new Stack();
        Stack<String> resStack = new Stack();
        int idx = 0;
        
        while (idx < s.length()) {
            
            // if char is digit
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }   // if char is [
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }   // if charis ]
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }   // if char is alphabet
            else {
                res += s.charAt(idx);
                idx++;
            }
            
        }
        
        return res;
    }
}
