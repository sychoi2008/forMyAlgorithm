package Algorithm.BOJ.search;

import java.util.*;
import java.io.*;

public class StartLink
{
    static int [][] skill; // 능력치 배열
    static int members; // 사람 수
    static boolean [] visited;
    static int min_value = Integer.MAX_VALUE;



    public static void solution(int index, int start) {
        if(index == members/2) { // 팀이 다 결성이 되면
            getResult();
            return;


        }


        for(int i=start; i<members; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(index + 1, i+1);
                visited[i] = false;
            }
        }
    }

    public static void getResult() {
        //visited를 돌면서 스타트팀인지 링크팀인지를 확인해서 능력치 계산하면 됨..

        int start = 0; // 능력치 합
        int link = 0;

        for(int i=0; i<members; i++) {
            for(int j=i+1; j<members; j++) {

                if(visited[i] && visited[j]) {
                    start += skill[i][j];
                    start += skill[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    link += skill[i][j];
                    link += skill[j][i];
                }
            }
        }

        int result = Math.abs(start-link);


        min_value = Math.min(result, min_value);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        members = Integer.parseInt(br.readLine());
        skill = new int [members][members];
        visited = new boolean[members];


        for(int i=0; i<members; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for(int j=0; j<members; j++) {
                skill[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        solution(0,0);
        System.out.println(min_value);


    }
}