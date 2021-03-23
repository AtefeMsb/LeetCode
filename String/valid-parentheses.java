class Solution {
    public boolean isValid(String s) {
        
        // if the length is odd, it is not a valid string
        if (s.length() % 2 == 1) { return false;}
        Deque<Character> stack = new ArrayDeque<>();

      for (char ch : s.toCharArray()) {
          
          if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
              stack.pop();
          } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
              stack.pop();
          } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
              stack.pop();
          } else {
              stack.push(ch);
          }
          
      }
        
        return stack.isEmpty();
        
        
    }
}
