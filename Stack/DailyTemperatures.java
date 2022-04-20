
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
// -----------------------------------------------------------
// Monotonic Decreasing Stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        // fill out the res with zero, so indices that do not have larger temptures coming will be already set to zero.
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        
        // [index, temperature]
        LinkedList<int[]> stack = new LinkedList<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                int[] cur = stack.pop();
                int index = cur[0];                
                res[index] = i - index;
            }
            
            stack.push(new int[]{i, temperatures[i]});
        }
    
        return res;
    }
}
// ------------------------------------------------------
// Monotonic Decreasing Stack - only save index on the stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        // fill out the res with zero, so indices that do not have larger temptures coming will be already set to zero.
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        
        // index
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            
            stack.push(i);
        }
    
        return res;
    }
}