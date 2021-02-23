class Solution {
    public String decodeString(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
                
        for (int index = 0; index < s.length(); index++) {
            
            if (s.charAt(index) != ']') {
                
                stack.push(s.charAt(index));
               
                // we hit the close ']'
            } else {
                // extracting all the characters from inside []
                List<Character> reversedChars = new ArrayList<>();
                
                while (stack.peek() != '[') {
                    reversedChars.add(stack.pop());
                }
                
                // pop one open bracker
                stack.pop();
                
                // extract the digits
                int acc = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    acc = acc + (stack.pop() - '0') * base;
                    base = base * 10;
                }
                
                List<Character> repeatedReversedChars = new ArrayList<>();
                // construct the string
                for (int i = 0; i < acc; i++) {
                    repeatedReversedChars.addAll(reversedChars);
                }
                
                // push the characters back to the stack from the end
                for (int i = repeatedReversedChars.size() - 1; i >= 0; i--) {
                    stack.push(repeatedReversedChars.get(i));
                }
    
            }
        }
        
        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()) {
            output.insert(0, stack.pop());
            
        }
        
        return output.toString();
        
    }
}