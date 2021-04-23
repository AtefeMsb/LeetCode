package BackTracking;

class TrieNode {
  String word;
  Map<Character, TrieNode> children;
  public TrieNode() {
      word = null;
      children = new HashMap<>();
  }
}

class Solution {
  List<String> result = new ArrayList<>();
  
  public List<String> findWords(char[][] board, String[] words) {
      
      // 1. create a trie with all the words dictionary
      TrieNode root = new TrieNode();
      for (String word : words) {
          TrieNode cur = root;
          for (char c : word.toCharArray()) {
              if (!cur.children.containsKey(c)) {
                  cur.children.put(c, new TrieNode());
              } 
              cur = cur.children.get(c);
          }
          cur.word = word;
      }
      
      // 2. start dfs search from each cell in the board grid
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              // if the first character was found on the trie
              if (root.children.containsKey(board[i][j])) {
                  backtracking(i, j, root, board);
              }
          }
      }
      
      return result; 
  }
  
  private void backtracking(int row, int col, TrieNode root, char[][] board) {
      
      char c = board[row][col];                // current character
      TrieNode cur = root.children.get(c);     // trienode associated with current character
      
      // base case - if there is a match
      if (cur.word != null) {
          result.add(cur.word);
          cur.word = null;
      }
   
      board[row][col] = '#';  // mark it before exploration
      int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      for (int[] direction : directions) {
          int newRow = row + direction[0];
          int newCol = col + direction[1];
          // skip out of bound cells
          if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
              continue;
          }
          // only if trie includes the new letter, do the backtracking
          if (cur.children.containsKey(board[newRow][newCol])) {
              backtracking(newRow, newCol, cur, board);
          }
      }
      
      board[row][col] = c;    // clean up after exploration  
      
       // Optimization: incrementally remove the leaf nodes
      if (cur.children.isEmpty()) {
          root.children.remove(c);
      }
      
  }
} 
