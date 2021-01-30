package dataStructures.tree.trie;

/**
 * @author: Bright Chan
 * @date: 2021/1/30 14:26
 * @description: 字典树节点
 */
public class TrieNode {
    // 该节点的子节点
    private TrieNode[] links;

    // 假设子节点最多有26个(字母表中的26个字符)
    private final int R = 26;

    // 该节点是否为叶子节点
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    // 是否有指定的子节点
    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }

    // 获得指定子节点
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }

    // 设置子节点
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }

    // 设置该节点为叶子节点
    public void setEnd() {
        isEnd = true;
    }

    // 该节点是否为叶子节点
    public boolean isEnd() {
        return isEnd;
    }
}
