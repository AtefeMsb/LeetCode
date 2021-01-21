package DynamicProgramming;

class UniqueBinarySearchTree {
    public int numTrees(int n) {
        
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
          for (int j = 1; j <= i; ++j) {
            G[i] += G[j - 1] * G[i - j];
          }
        }
        
        System.out.println(Arrays.toString(G));
        
        return G[n];
    }
}


// UniqueBinarySearchTree2 is in recursion folder