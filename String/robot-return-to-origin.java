//USING TWO STACKS
/*class Solution {
    public boolean judgeCircle(String moves) {
        
        Stack<Character> upDown = new Stack<>();
        Stack<Character> rightLeft = new Stack<>();
        
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                if (!upDown.isEmpty() && upDown.peek() == 'D') {
                    upDown.pop();
                } else {
                    upDown.push(ch);
                }
                
            } else if (ch == 'D') {
                 if (!upDown.isEmpty() && upDown.peek() == 'U') {
                    upDown.pop();
                } else {
                    upDown.push(ch);
                }
                
            }
            if (ch == 'R') {
                if (!rightLeft.isEmpty() && rightLeft.peek() == 'L') {
                    rightLeft.pop();
                } else {
                    rightLeft.push(ch);
                }
                
            } else if (ch == 'L') {
                 if (!rightLeft.isEmpty() && rightLeft.peek() == 'R') {
                    rightLeft.pop();
                } else {
                    rightLeft.push(ch);
                }
                
            } 
        }
        
        return rightLeft.isEmpty() && upDown.isEmpty();
        
    }
}
*/
// USING TWO VARIABLE
class Solution {
    public boolean judgeCircle(String moves) {
        int v = 0; // vertical
        int h = 0; // horizontal
        
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'R':
                    h++;
                    break;
                case 'L':
                    h--;
                    break;
                default:
                    break; 
            }  
        }
        
        return v == 0 && h == 0; 
    }
}
