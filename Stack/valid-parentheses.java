class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 2 == 1) {
            return false;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(')  {
               stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')  {
               stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')  {
               stack.pop();
            } else {
                return false;
            }
           
        }
        
        return stack.isEmpty();
          
    }
}