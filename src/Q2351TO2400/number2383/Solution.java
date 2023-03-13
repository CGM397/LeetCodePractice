package Q2351TO2400.number2383;

/**
 * @author: Solution
 * @date: 2023/3/13 22:13
 * @description: minNumberOfHours
 */
public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        for (int current : energy) {
            if (initialEnergy <= current) {
                res += current - initialEnergy + 1;
                initialEnergy = 1;
            }
            else {
                initialEnergy -= current;
            }
        }

        for (int current : experience) {
            if (initialExperience <= current) {
                int k = current - initialExperience + 1;
                res += k;
                initialExperience += k;
            }
                initialExperience += current;
        }
        return res;
    }
}
