// we want to keep a monotonic increasing stack
class Solution {
    public String removeKdigits(String num, int k) {
        
        if (num.length() <= k) return "0";
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for (char c : num.toCharArray()) {
            
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                k--;
                stack.pop();
            }
            
            stack.push(c);
        }
          
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        // cut the k last elements, in case everything was in increasing order
        String res = sb.toString();
        res = res.substring(0, res.length() - k);
        
        // to solve leading zero problem convert to int and then convert back to string
        int resInt = Integer.valueOf(res);
        return "" + resInt;
    }
}