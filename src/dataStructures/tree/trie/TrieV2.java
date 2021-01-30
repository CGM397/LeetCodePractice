package dataStructures.tree.trie;

import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/1/30 14:37
 * @description: 字典树.V2
 */
public class TrieV2 {

    private TrieNodeV2 root;

    public TrieV2() {
        this.root = new TrieNodeV2();
    }

    public void insert(String word) {
        Map<Character, TrieNodeV2> children = root.getChildren();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNodeV2 next;
            if (children.containsKey(c)) {
                next = children.get(c);
            }
            else {
                next = new TrieNodeV2(c);
                children.put(c, next);
            }

            children = next.getChildren();

            if (i == word.length() - 1) {
                next.setEnd(true);
            }
        }
    }

    public boolean search(String word) {
        TrieNodeV2 t = searchNode(word);

        return t != null && t.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNodeV2 searchNode(String str) {
        Map<Character, TrieNodeV2> children = root.getChildren();

        TrieNodeV2 cur = null;

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
}
