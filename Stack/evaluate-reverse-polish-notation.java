class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack();
        int result = 0;
            
        int firstOperand;
        int secondOperand;

          for (String token : tokens) {
            switch (token) {
              case "+":
                stack.push(stack.pop() + stack.pop());
                break;
                    
              case "/":
                secondOperand = stack.pop();
                firstOperand = stack.pop();
                stack.push(firstOperand / secondOperand);
                break;
                    
              case "*":
                stack.push(stack.pop() * stack.pop());
                break;
                    
              case "-":
                secondOperand = stack.pop();
                firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
                break;
                    
              default:
                stack.push(Integer.parseInt(token)); 
            }
          }
        return stack.pop();
    }
}
