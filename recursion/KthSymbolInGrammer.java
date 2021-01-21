package recursion;

// intuition: https://www.youtube.com/watch?v=QRa9ZVGMWlY&ab_channel=PotatoCoders
// Time complexity: O(N log K) because modulo operation is log K
// Space complexity: O(N)

class KthSymbolInGrammer {
    public int kthGrammar(int N, int K) {
        
        if (N == 1) {return 0;}
        
        // alway round up K, to get to the parent Index
        int parent = kthGrammar(N-1, K / 2 + K % 2);
        boolean isOdd = ((K % 2) == 1);
                                
        int res = -1;
        
        if (parent == 1) { // 1 0
            // first char
            if (isOdd) {
                res = 1;
                
            // second char
            } else {
                res = 0;
            }
        }
        
         if (parent == 0) { // 0 1
            if (isOdd) {
                res = 0;
            } else {
                res = 1;
            }
        }
                                
        return res;                   
        
    }
}