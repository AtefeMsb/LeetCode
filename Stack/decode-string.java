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
// -----------------------------------------------
// using 2 stacks
class Solution {
    public String decodeString(String s) {
        
        Deque<Integer> counts = new ArrayDeque <>();
        Deque<String> results = new ArrayDeque<>();
        int ptr = 0;
        String result = "";
        
        while (ptr < s.length()) {
            
            char cur = s.charAt(ptr);
            // 1. if cur is digit
            if (Character.isDigit(cur)) {
                
                // create the whole number for exampe: 32
                int num = 0;
                while (Character.isDigit(s.charAt(ptr))) {
                    num = num * 10 + s.charAt(ptr) - '0';
                    ptr++;
                }
                counts.push(num);
                
            // 2. if cur is '[' - start of a new string
            } else if (cur == '[') {
                
                results.push(result);
                result = "";
                ptr++;
              
            // 3. if cur is ']'
            } else if (cur == ']') {
                
                StringBuilder sb = new StringBuilder(results.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(result);
                }
                
                // update it to the whole string we have been creating
                result = sb.toString();    
                ptr++;
            
            // 4. if cur is a alphabet
            } else {
                
                result += cur;
                ptr++;
                
            }
        }
        
        return result;
        
    }
}

// ----------------------------------------------------
// best answer
class Solution {
    public String decodeString(String s) {
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for (int index = 0; index < s.length(); index++) {
            
            
            if (s.charAt(index) != ']') {
                
                stack.push(s.charAt(index));
            
            // when see a close bracket
            } else {
                
                // step 1: get all the characters inside []
                StringBuilder sb = new StringBuilder();
                while (Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String letters = sb.toString();
                
                // step 2: discard '['
                stack.pop();
                
                // step 3: get all the digits before []
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                
                int count = Integer.valueOf(sb.toString());
                
                // step 4: add the letters from inside [], COUNT times to teh stack
                for (int i = 0; i < count; i++) {
                    for (char l : letters.toCharArray()) {
                        stack.push(l);
                    }
                }
                
            }
        }
        
        // because the string gets reversed when added to stack
        // we reverse them again by inserting to 0 index
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }
}