package Q2301TO2350.number2347;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Solution
 * @date: 2023/2/20 21:33
 * @description: bestHand
 */
public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> storeRanks = new HashMap<>();
        Map<Character, Integer> storeSuits = new HashMap<>();

        for (int i : ranks) {
            storeRanks.put(i, storeRanks.getOrDefault(i, 0) + 1);
        }
        for (char i : suits) {
            storeSuits.put(i, storeSuits.getOrDefault(i, 0) + 1);
        }

        if (storeSuits.size() == 1) {
            return "Flush";
        } else if (storeRanks.size() <= 2) {
            return "Three of a Kind";
        } else if (storeRanks.size() == 3) {
            int maxValue = 0;
            for(Map.Entry<Integer,Integer> entry : storeRanks.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                }
            }
            if (maxValue == 3) {
                return "Three of a Kind";
            } else {
                return "Pair";
            }
        } else if (storeRanks.size() == 4) {
            return "Pair";
        }
        return "High Card";
    }
}
