package Trie;

// bruth force
class MapSum {

    Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int ans = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                ans += map.get(key);
            }
        }
        
        return ans;
    }
}

//--------------------------------------------------------------------
// using Trie
class MapSum {
    HashMap<String, Integer> map;
    TrieNode root;
    
    public MapSum() {
        map = new HashMap();
        root = new TrieNode();
    }
    public void insert(String key, int val) {
        // zero if undefined
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        
        TrieNode cur = root;
        cur.score += delta;
        
        for (char c: key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c: prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return 0;
        }
        return cur.score;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    int score;
}