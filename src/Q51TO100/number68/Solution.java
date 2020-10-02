package Q51TO100.number68;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/9/11 13:27
 * @description: 数组处理
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, j, width, extraSpace, wordsNum;
        while (i < words.length) {
            width = -1;
            j = i;
            while (i < words.length && width + words[i].length() + 1 <= maxWidth) {
                width += words[i].length() + 1;
                i++;
            }
            StringBuilder oneRes = new StringBuilder(words[j]);
            wordsNum = i - j;
            // 除去单词和单词之间的一个空格之后还剩的空格数
            extraSpace = maxWidth - width;
            // 如果只有一个单词，则按照左对齐方式
            if (wordsNum == 1) {
                for (int m = 0; m < extraSpace; m++)
                    oneRes.append(" ");
                res.add(oneRes.toString());
                continue;
            }
            // 如果是最后一行，则按照左对齐方式
            if (i == words.length) {
                for (int k = j + 1; k < i; k++) {
                    oneRes.append(" ");
                    oneRes.append(words[k]);
                }
                for (int m = 0; m < extraSpace; m++)
                    oneRes.append(" ");
                res.add(oneRes.toString());
                continue;
            }
            // 分配给单词之间的空格数
            int spaceNum = (extraSpace + wordsNum - 1) / (wordsNum - 1);
            // 分配完剩下的空格数
            int leftSpace = (extraSpace + wordsNum - 1) % (wordsNum - 1);

            for (int k = j + 1; k < i; k++) {
                for (int m = 0; m < spaceNum; m++) {
                    oneRes.append(" ");
                }
                if (leftSpace > 0) {
                    oneRes.append(" ");
                    leftSpace--;
                }
                oneRes.append(words[k]);
            }
            res.add(oneRes.toString());
        }

        return res;
    }

}
