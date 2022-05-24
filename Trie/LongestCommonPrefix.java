/*
https://leetcode.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Input: strs = ["flower","flow","flight"]
Output: "fl"
 */

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isComplete;

    public TrieNode() {
        children = new HashMap<>();
        isComplete = false;
    }

    public int getSize() {
        return children.size();
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {

        TrieNode cur = root;
        for (char ch : str.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }

        cur.isComplete = true;
    }

    public TrieNode getRoot() {
        return root;
    }
}

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String prefix1 = longestCommonPrefix(new String[] {"flower","flow","flight"});
        String prefix2 = longestCommonPrefix(new String[] {"dog","racecar","car"});
        String prefix3 = longestCommonPrefix(new String[] {"rain","rainy","radius"});
        System.out.println(prefix3);
    }

    public static String longestCommonPrefix(String[] strs) {

        Trie trie = new Trie();

        for (String str : strs) {
            trie.insert(str);
        }

        return searchLongestCommonPrefix(strs, trie);

    }

    public static String searchLongestCommonPrefix(String[] strs, Trie trie) {

        // search for the common prefix using teh first word in the dictionary strs[0]
        String firstWord = strs[0];
        TrieNode cur = trie.getRoot();

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < firstWord.length(); i++) {

            char curChar = firstWord.charAt(i);
            if (cur.children.containsKey(curChar) && cur.getSize() == 1 && cur.isComplete != true) {
                prefix.append(curChar);
                cur = cur.children.get(curChar);
            } else {
                return prefix.toString();
            }

        }
        return prefix.toString();
    }
}