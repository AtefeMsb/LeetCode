class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        LinkedList<Integer> stack = new LinkedList<>();
        
        // collision is + and then -
        for (int asteroid : asteroids) {
            // crash: if asteroid is negative and the top of the stack is positive
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int diff = asteroid + stack.peek();
                // right one wins
                if (diff < 0) {
                    stack.pop();
                // left one wins
                } else if (diff > 0) {
                    asteroid = 0;
                // the both gets destroyed
                } else if (diff == 0) {
                    stack.pop();
                    asteroid = 0;
                }
            }
            
            // add the asteroid to stack
            if (asteroid != 0) {
                stack.push(asteroid);
            }
            
        }
        
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(0, stack.pop());
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
        
    }
}
