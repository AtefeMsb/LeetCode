class Solution {
    public int minAddToMakeValid(String s) {
        
        LinkedList<Character> stack = new LinkedList<>();
        int extraClose = 0;
        int extraOpen = 0;
        
        for (char c : s.toCharArray()) {
            
            if (c == '(') {
                
                stack.push(c);
                
            } else if (c == ')') {
                
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    extraClose++;
                }  
            }
        }
        
        // whatever left in the stack is open parantehsis that have not been closed
        extraOpen = stack.size();
        
        return extraClose + extraOpen;
    }
}