class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        // edge case
        if (firstList.length == 0 || secondList.length == 0) return new int[0][0];
        
        int pA = 0;
        int pB = 0;
        List<int[]> results = new ArrayList<>();
        
        while (pA < firstList.length && pB < secondList.length) {
            int start = Math.max(firstList[pA][0], secondList[pB][0]);
            int end = Math.min(firstList[pA][1], secondList[pB][1]);
            
            // if there is an intersect
            if (start <= end) {
                results.add(new int[]{start, end});
            } 
            
            // which pointer to move
            if (firstList[pA][1] < secondList[pB][1]) {
                pA++;
            } else {
                pB++;
            }
            
        }
        
        return results.toArray(new int[results.size()][]);
    }
}