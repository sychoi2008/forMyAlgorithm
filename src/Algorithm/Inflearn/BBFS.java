package Algorithm.Inflearn;

import java.util.*;

public class BBFS {
    static HashMap<Integer, Boolean> visited = new HashMap<>();
    public static void bfs(Map<Integer, List<Integer>> graph, int startVertex) {
        // 초기세팅
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visited.put(startVertex, true);

        while(!queue.isEmpty()) {
            int curVertex = queue.poll();
            for(int nextVertex : graph.get(curVertex)) {
                if(!visited.containsKey(nextVertex)) { //visited에 없을 때
                    queue.offer(nextVertex);
                    visited.put(nextVertex, true);
                }
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
        bfs(graph, startVertex);
    }
}
