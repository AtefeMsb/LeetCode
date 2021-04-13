package Trie;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isComplete;
    
    public TrieNode() {
        children = new HashMap<>();
        isComplete = false;     // marks the end of the word
    }
}

class WordDictionary {

    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.isComplete = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, root);
        
    }
    
    public boolean searchInNode(String word, TrieNode node) {
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (ch == '.') {
                    for (char x: node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i+1), child)) {
                            return true;
                        }
                    }
                }
                
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                node = node.children.get(ch);
            }
        }
        
        return node.isComplete;
    }
}
