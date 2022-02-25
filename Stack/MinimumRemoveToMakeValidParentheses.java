/*
step 1. get rid of excess ) using the for loop
step 2. getting rid of excess ( using the for loop
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        
        LinkedList<Integer> openStack = new LinkedList<>();
        char[] chars = s.toCharArray();
        
        // step 1
        for (int i = 0; i < chars.length; i++) {
            // push INDEX of all the open parenthesis
            if (chars[i] == '(') {
                openStack.push(i);
            // close parenthesis only gets added if there is open before them
            } else if (chars[i] == ')') {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                // mark unplaced close parenthesis
                } else {
                    chars[i] = '*';
                }
            }
        }
        
        // step 2
        // remove the excess open parenthesis
        while (!openStack.isEmpty()) {
            int index = openStack.pop();
            chars[index] = '*';
        }
        
        // build the final string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '*') {
                sb.append(chars[i]);
            }
        }
        
        return sb.toString();    
    }
}