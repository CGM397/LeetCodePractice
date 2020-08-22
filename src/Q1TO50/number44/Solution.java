package Q1TO50.number44;

/**
 * @author: Bright Chan
 * @date: 2020/8/16 14:35
 * @description: 字符串匹配
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*') {
            if (charMatch(s.charAt(sRight - 1), p.charAt(pRight - 1))) {
                --sRight;
                --pRight;
            } else {
                return false;
            }
        }

        if (pRight == 0) {
            return sRight == 0;
        }

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;

        while (sIndex < sRight && pIndex < pRight) {
            if (p.charAt(pIndex) == '*') {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            } else if (sRecord != -1 && sRecord + 1 < sRight) {
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }

        return allStars(p, pIndex, pRight);
    }

    public boolean allStars(String str, int left, int right) {
        for (int i = left; i < right; ++i) {
            if (str.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }

    //超时了
    private boolean res = false;
    public boolean myIsMatch(String s, String p) {
        if (s == null || p == null) return false;

        backTracking(s, p);
        return res;
    }

    private void backTracking(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            res = true;
            return;
        }
        //s长度一定大于0
        if (p.length() == 0) {
            res = false;
            return;
        }
        // p长度一定大于0
        // 应对case: s = ""; p = "*";
        if (s.length() == 0) {
            int i = 0;
            while (i < p.length() && p.charAt(i) == '*') i++;
            res = i == p.length();
            return;
        }

        if (p.charAt(0) != '*' && p.charAt(0) != '?') {
            int i = 0;
            while (i < s.length() && i < p.length() && s.charAt(i) == p.charAt(i)) {
                i++;
            }
            if (i == 0) {
                res = false;
            }
            else {
                backTracking(s.substring(i), p.substring(i));
            }
        }
        else if (p.charAt(0) == '?') {
            backTracking(s.substring(1), p.substring(1));
        }
        else if (p.charAt(0) == '*') {
            //去除多余的*号
            int j = 1;
            while (j < p.length() && p.charAt(j) == '*') j++;
            p = p.substring(j - 1);

            if (p.length() > 1) {
                if (s.charAt(0) == p.charAt(1) || p.charAt(1) == '?') {
                    //*号匹配空字符串
                    backTracking(s.substring(1), p.substring(2));
                    if (res) return;
                }

                for (int i = s.length() - 1; i >= 1; i--) {
                    if (s.charAt(i) == p.charAt(1) || p.charAt(1) == '?') {
                        backTracking(s.substring(i + 1), p.substring(2));
                        if (res) return;
                    }
                }
            }
            else {
                res = true;
            }
        }
    }
}
