package Algorithm.Inflearn;

import java.util.*;

public class DFSPractice {
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

    }
}
