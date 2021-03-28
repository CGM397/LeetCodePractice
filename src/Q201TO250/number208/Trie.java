package Q201TO250.number208;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/3/27 16:36
 * @description: 前缀树
 */
public class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root  = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, TrieNode> children = root.getChildren();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode next;
            if (children.containsKey(c)) {
                next = children.get(c);
            }
            else {
                next = new TrieNode(c);
                children.put(c, next);
            }

            children = next.getChildren();

            if (i == word.length() - 1) {
                next.setEnd(true);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode res = searchNode(word);

        return res != null && res.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.getChildren();

        TrieNode cur = null;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.getChildren();
            }
            else {
                return null;
            }
        }

        return cur;
    }

    public static class TrieNode {
        private char c;

        private Map<Character, TrieNode> children = new HashMap<>();

        private boolean isEnd = false;

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode() {

        }

        public char getC() {
            return c;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}
