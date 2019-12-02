// stack - hashmap
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> nextGreatest = new HashMap<>();
        int[] result = new int[nums1.length];
        
        // 1- find each number next greater elements using stack
        for (int num : nums2) {
            // NOTE: this part is for decresing part of nums2
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreatest.put(stack.pop(), num);
            }
            
            stack.push(num);
        }
        
        // 2- create a result array of all next greater elements, in case it doesnt exist 
        // put -1 
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreatest.getOrDefault(nums1[i], -1);
        }
            
        return result;
    }
    
}
