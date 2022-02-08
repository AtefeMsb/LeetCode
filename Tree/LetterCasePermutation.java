// dfs
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtrack(s.toCharArray(), 0);
        return list;
    }
    
    public void backtrack(char[] arr, int i) {
        
        if (i == arr.length) {
            list.add(new String(arr));
            return;
        }
        
        // if current character is digit
        if (Character.isDigit(arr[i])) {
            backtrack(arr, i + 1);
        }
        
        // if current character is letter
        if(Character.isLetter(arr[i])){ 
            
            arr[i] = Character.toUpperCase(arr[i]);
            backtrack(arr, i+1); //Upper case branch
            arr[i] = Character.toLowerCase(arr[i]);
            backtrack(arr, i+1); //Lower case branch 
            
        }
    }
}

// ------------------------------------------------------
// bfs
class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        
        return new LinkedList<>(queue);
    }
}
