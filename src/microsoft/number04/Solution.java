package microsoft.number04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/10/16 12:54
 * @description: TODO
 */
public class Solution {
    public int solution(String[] A) {
        List<String> store = new ArrayList<>();
        int[] bitFlag = new int[26];
        // max len with only one string
        int res = 0;
        // delete strings like "yyy"
        for (String one : A) {
            if (!hasDulChar(one)) {
                store.add(one);
                res = Math.max(res, one.length());

                for (char oneChar : one.toCharArray()) {
                    bitFlag[oneChar - 'a']++;
                }
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            maxUniqLen(store, i, 0, bitFlag);
            if (tmpRes != -1) {
                return tmpRes;
            }
        }

        return res;
    }

    private int tmpRes = -1;
    private void maxUniqLen(List<String> store, int delCount, int step, int[] bitFlag) {
        if (delCount == 0) {
            tmpRes = Math.max(tmpRes, getMaxLen(bitFlag));
            return;
        }

        for (int i = step; i < store.size(); i++) {
            String selectedStr = store.get(i);
            for (char oneChar : selectedStr.toCharArray()) {
                bitFlag[oneChar - 'a']--;
            }
            maxUniqLen(store, delCount - 1, step + 1, bitFlag);
            for (char oneChar : selectedStr.toCharArray()) {
                bitFlag[oneChar - 'a']++;
            }
        }
    }

    private boolean hasDulChar(String one) {
        boolean[] flag = new boolean[26];
        for (char oneChar : one.toCharArray()) {
            if (flag[oneChar - 'a']) {
                return true;
            }
            else {
                flag[oneChar - 'a'] = true;
            }
        }

        return false;
    }

    private int getMaxLen(int[] bitFlag) {
        int res = 0;
        for (int one : bitFlag) {
            if (one > 1) {
                return -1;
            }
            else if (one == 1) {
                res++;
            }
        }
        return res;
    }
}
