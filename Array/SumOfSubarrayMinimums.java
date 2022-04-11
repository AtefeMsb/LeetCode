// https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step

class Solution {
    public int sumSubarrayMins(int[] A) {
        int len = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        int[] right = new int[len];
        
        for(int i = 0; i < A.length; i++) {
            left[i] = i + 1;
            right[i] = len - i;
        }
        
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        
        
        // previous less element
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        
        //next less element
        stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) {
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        
        int ans = 0;
        int mod = 1000000007;
        for(int i = 0; i < len; i++) {
            ans = (ans + A[i] * left[i] * right[i]) % mod;
        }
        return ans;
    }
}