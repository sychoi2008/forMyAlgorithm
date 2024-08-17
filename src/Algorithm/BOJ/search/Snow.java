package Algorithm.BOJ.search;

import java.util.*;
import java.io.*;
public class Snow {
    static boolean flag = false;
    static int [] people;
    static boolean [] visited;
    static int [] answer;
    public static void solution(int sum, int index) {
        if(index == 7) {
            if(sum == 100) {
                Arrays.sort(answer);
                for(int num : answer) {
                    System.out.println(num);
                }
                flag = true;
                return;
            }
            else return;

        }

        for(int i=0; i<9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[index] = people[i];
                solution(sum+people[i], index+1);
                if(flag == true) return;
                visited[i] = false; // 원래대로

            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        people = new int[9];
        visited = new boolean[9];
        answer = new int[7];

        for(int i=0; i<9; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        solution(0, 0);
    }
}