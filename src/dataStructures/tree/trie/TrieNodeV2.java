package dataStructures.tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/1/30 14:32
 * @description: 字典树节点.V2
 */
public class TrieNodeV2 {

    private char c;

    private Map<Character, TrieNodeV2> children = new HashMap<>();

    private boolean isEnd = false;

    public TrieNodeV2(char c) {
        this.c = c;
    }

    public TrieNodeV2() {

    }

    public char getC() {
        return c;
    }

    public Map<Character, TrieNodeV2> getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
