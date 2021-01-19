package Graph;

/*
Complexity Analysis

Let NN be the number of people, and EE be the number of edges (trust relationships).

Time Complexity : O(E).

We loop over the trust list once. The cost of doing this is O(E).

We then loop over the people. The cost of doing this is O(N).

Going by this, it now looks this is one those many graph problems where the cost is O(max(N,E)=O(N+E). After all, we don't know whether E or N is the bigger one, right?

However, remember how we terminate early if E<N−1? This means that in the best case, the time complexity is O(1). And in the worst case, we know that E≥N−1. For the purpose of big-oh notation, we ignore the constant of 1. Therefore, in the worst case, E has to be bigger, and so we can simply drop the NN, leaving O(E).

Space Complexity : O(N).

We allocated 2 arrays; one for the indegrees and the other for the outdegrees. Each was of length N + 1. Because in big-oh notation we drop constants, this leaves us with O(N)O(N).
*/
class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        
        // a town judge must have N - 1 in-going edges, and so if there aren't at least N - 1 edges in total,
        // then it is impossible to meet this requirement.
        if (trust.length < N - 1) {
            return -1;
        }
        
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        
        for (int[] relation : trust) {
            
            outDegree[relation[0]]++;
            inDegree[relation[1]]++;
  
        }
        
        for (int i = 1; i <= N; i++) {
            
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }
}