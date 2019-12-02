/*
Loop once, we can get the Next Greater Number of a normal array.
Loop twice, we can get the Next Greater Number of a circular array

The first typical way to solve circular array problems is to extend the original array to twice length, 2nd half has the same element as first half.
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> stack = new Stack();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()]= nums[i % n];
            }
            
            stack.push(i % n);
        }

        return result;
    }
}
