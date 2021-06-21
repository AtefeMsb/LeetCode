class Solution {
    public boolean isValid(String s) {
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for (char c : s.toCharArray()) {
            
            if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
            
        }
        
        return stack.isEmpty();
    }
}