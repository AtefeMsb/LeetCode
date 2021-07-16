
class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        
        // start from the end
        for (int i = T.length - 1; i >= 0; i--) {
            // while stack not empty and stack top is colder than the current day
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            // if we found a warmer day, calculate the number of day with the current day
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }
            
            stack.push(i);
        }
        
        return result;
        
    }
}