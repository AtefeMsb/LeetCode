package AuguestChallenge2020;

class HIndex {
    public int hIndex(int[] citations) {
        
        int len = citations.length;
        
        // O(nlogn)
        Arrays.sort(citations);
        
        // i is the count of values seen so far
        // len - 1 - i is the index needed for traversal backward 
        int i = 0;
                
        // O(n)
        while (i < len  && citations[len - 1 - i] > i) {
           i++;
        }

        System.out.println(Arrays.toString(citations));
        System.out.println(i);
        return i;
            
    }
}