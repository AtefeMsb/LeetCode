package Trie;

// prefix hash
class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        
        Set<String> rootset = new HashSet();
        for (String root: roots) rootset.add(root);

        StringBuilder ans = new StringBuilder();
        
        for (String word: sentence.split("\\s+")) {
            
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) break;
            }
            
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }
}

///////////////////////////////////////////////////////
// Trie
class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        // put all the roots word in a trie
        TrieNode trie = new TrieNode();
        for (String root: roots) {
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (!cur.children.containsKey(letter))
                    cur.children.put(letter, new TrieNode());
                cur = cur.children.get(letter);
            }
            cur.completeWord = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");
            
            TrieNode cur = trie;
            for (char letter: word.toCharArray()) {
                // if letter is not in the trie OR the "completeWord" variable is NOT NULL,
                // meaning this node is end of a trie path
                if (!cur.children.containsKey(letter) || cur.completeWord != null) {
                    break;
                }
                cur = cur.children.get(letter);
                
            }
            // if the node completeWord variable is NOT NULL means we found a root that matches
            ans.append(cur.completeWord != null ? cur.completeWord : word);
        }
        return ans.toString();
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    // hold the complete word at the last node, the rest are null
    String completeWord;
    TrieNode() {
        children = new HashMap<>();
    }
}