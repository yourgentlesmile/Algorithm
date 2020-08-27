import java.util.*;

/**
 * https://leetcode-cn.com/problems/reconstruct-itinerary
 * dfs + 回溯
 */
public class T332 {
    private Map<String, ArrayList<String>> map = new HashMap<>();
    private List<String> res = new ArrayList<>();
    private int fly = 0;
    public List<String> findItinerary(List<List<String>> tickets) {
        fly = tickets.size();
        for(List<String> t : tickets) {
            ArrayList<String> dist = map.getOrDefault(t.get(0), new ArrayList<>());
            dist.add(t.get(1));
            map.putIfAbsent(t.get(0), dist);
        }
        res.add("JFK");
        dfs("JFK");
        return res;
    }

    public boolean dfs(String departure) {
        ArrayList<String> next = map.get(departure);
        if(next == null || next.size() == 0) {
            return fly == 0;
        }
        Collections.sort(next);
        Object[] objects = next.toArray();
        for (Object s : objects) {
            res.add((String)s);
            next.remove(s);
            fly--;
            if(dfs((String)s)) return true;
            res.remove(res.size() - 1);
            next.add((String)s);
            fly++;
        }
        return false;
    }
}
