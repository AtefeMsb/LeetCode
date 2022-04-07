class TrieNode {
    Map<Character, TrieNode> children;
    boolean isComplete;
    
    public TrieNode() {
        children = new HashMap<>();
        isComplete = false;
    }
}

class Solution {

    // find all the words that start with the prefix in order lexigraphically
    private List<String> startsWith(TrieNode root, String prefix) {

        List<String> list = new ArrayList<>();

        // find the prefix in the trie
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (cur.children.get(ch) == null) {
                return list;
            }
            cur = cur.children.get(ch);
        }

        // get all the tail of the prefix after this node
        List<String> tails = new ArrayList<>();
        util(cur, "", tails);

        // maximum 3 of the matches is needed
        for (int i = 0; i < Math.min(tails.size(), 3); i++) {
            String tail = tails.get(i);
            String word = prefix + tail;
            list.add(word);
        }

        return list;
    }

        // dfs function to find all the possible words after a certain TrieNode root
        private void util(TrieNode root, String prefix, List<String> res) {

            if (root == null) return;

            if (root.isComplete == true) {
                res.add(prefix);
            }   

            List<Character> temp = new ArrayList<>(root.children.keySet());
            Collections.sort(temp);

            for (char c : temp) {
                util(root.children.get(c), prefix + c, res);  
            }

        }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        // build a trie
        TrieNode root = new TrieNode();
        List<List<String>> res = new ArrayList<>();

        // insert every product in the trie
        for (String s : products) {
            TrieNode cur = root;

            for (char c : s.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.isComplete = true;
        }
        
            
        // go through every substring
        for (int i = 1; i < searchWord.length() + 1; i++) {
            String prefix = searchWord.substring(0, i);
            res.add(startsWith(root, prefix));
        }

        return res;
    }
}