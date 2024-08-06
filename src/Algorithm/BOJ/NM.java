package Algorithm.BOJ;

import java.util.*;
import java.io.*;


public class NM {
    static int N;
    static int M;
    static boolean [] visited;

    public static void solution(String str, int index) {
        if(index == M) {
            System.out.println(str);
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(str+i+" ", index+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean [N+1];

        solution("", 0);
    }
}
