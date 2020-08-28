package Q301TO350.number332;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2020/8/27 10:30
 * @description: Hierholzer 算法，欧拉回路/欧拉通路
 */
public class Solution {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }

    private List<List<String>> store = new ArrayList<>();
    private Stack<String> oneRes = new Stack<>();
    private boolean[] flag;
    public List<String> myFindItinerary(List<List<String>> tickets) {
        flag = new boolean[tickets.size()];
        Arrays.fill(flag, false);
        oneRes.push("JFK");
        backTracking("JFK", 0, tickets);
        String min = String.join("", store.get(0));
        int minPos = 0;
        for (int i = 0; i < store.size(); i++) {
            String one = String.join("", store.get(i));
            if (one.compareTo(min) < 0) {
                min = one;
                minPos = i;
            }
        }

        return store.get(minPos);
    }

    public void backTracking(String currentAirport, int steps, List<List<String>> tickets) {

        if (steps == tickets.size()) {
            store.add(new ArrayList<>(oneRes));
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            List<String> one = tickets.get(i);
            if (!flag[i] && one.get(0).equals(currentAirport)) {
                flag[i] = true;
                oneRes.push(one.get(1));
                backTracking(one.get(1), steps + 1, tickets);
                flag[i] = false;
                oneRes.pop();
            }
        }
    }
}
