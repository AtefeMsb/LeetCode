/**
* greedy solution: to maximize length of pair chain, choose the next addidtion to be the one with lowest second coordinate
* time complexity: O(nlongn) from sorting step
* space complexity: O(n)
*/
class Solution {
    public int findLongestChain(int[][] pairs) {
        
        // sort by finish time
        // finish first strategy
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        int cur = Integer.MIN_VALUE;
        int result = 0;
        
        for (int[] pair: pairs) {
            if (pair[0] > cur) {
                cur = pair[1];
                result++;
            }
        }
        return result;
    }
}