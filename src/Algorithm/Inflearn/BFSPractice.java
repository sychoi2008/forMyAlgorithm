package Algorithm.Inflearn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFSPractice {
    static HashMap<Integer, Boolean> visited = new HashMap<>();
    public static void dfs(Map<Integer, List<Integer>> graph, int curVertex) {
        visited.put(curVertex, true);
        for(int nextVertex : graph.get(curVertex)) {
            if(!visited.containsKey(nextVertex)) {
                dfs(graph, nextVertex);
            }
        }
    }
    public static void main(String[] args) {

    }
}
