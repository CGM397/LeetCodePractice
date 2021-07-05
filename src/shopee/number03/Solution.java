package shopee.number03;

/**
 * @author: Bright Chan
 * @date: 2021/7/5 15:58
 * @description: 字符串
 */
public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param param string字符串
     * @return string字符串
     */
    public String compressString(String param) {
        int pre = 0, cur = 0;
        StringBuilder res = new StringBuilder();

        char[] store = param.toCharArray();
        int len = store.length;
        while (cur < len) {
            while (cur < len && store[cur] == store[pre]) {
                cur++;
            }
            res.append(store[pre]);
            int subStrLen = cur - pre;
            if (subStrLen > 1) {
                res.append(subStrLen);
            }

            pre = cur;
        }
        return res.toString();
    }
}
