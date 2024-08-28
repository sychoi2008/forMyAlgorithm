package Algorithm.BOJ.구현;

//https://stdio-han.tistory.com/106
import java.util.*;
import java.io.*;

public class Bridge {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭
        int W = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 다리 최대 하중

        Queue<Integer> truck = new LinkedList<>(); // 트럭을 넣을 큐
        Queue<Integer> bridge = new LinkedList<>(); // 다리

        int count = 0; // 시간
        int bridgeWeight = 0; // 현재 다리 위 트럭 무게
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<W; i++) {
            bridge.add(0); // 다리 길이 만큼 다 0으로 채움
        }

        while(!bridge.isEmpty()) { // 다리가 다 비워질 때까지 반복
            count++; // 일단 시간은 흐른다
            // 트럭이 지나가는 것, 트럭이 1 움직이기
            // 트럭이 다리에서 내려오는거!!!!!!!!!!!!!
            bridgeWeight-=bridge.poll(); // 1시간흐름 = 트럭 하나가 자리를 움직임
            if(!truck.isEmpty()) { // 모든 트럭들이 다 지나갈 때 까지
                // 현재 진입해야할 트럭 + 현재 다리 위 트럭 무게 <= 다리 최대 하중
                if(truck.peek() + bridgeWeight <= L ){
                    bridgeWeight += truck.peek(); // 현재 다리 무게에 트럭을 추가
                    bridge.add(truck.poll()); // 다리에 올리기
                } else bridge.add(0); // 진입할 트럭은 있지만 다리 최대 하중 때문에 올라가지 못해서 트럭의 1 움직임을 위해 0추가
            }
        }
        System.out.println(count);
    }
}