package Algorithm.Inflearn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DDFS {
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
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1,3,6));
        // 배열을 list로 바꿔주는 메소드 asList
        graph.put(1, Arrays.asList(0,3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(0,1,2,7));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(4,6,7));
        graph.put(6, Arrays.asList(0,5));
        graph.put(7, Arrays.asList(3,5));

        int startVertex = 0;
        dfs(graph, startVertex);
    }
}
