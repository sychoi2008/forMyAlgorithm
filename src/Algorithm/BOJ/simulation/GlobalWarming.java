package Algorithm.BOJ.simulation;

import java.util.*;
import java.io.*;

public class GlobalWarming {
    static char [][] grid;
    static boolean [][] visited;

    static void changeSea(int i, int j, int R, int C) {

        int cnt = 0; // 인접한 바다의 칸 개수

        int [][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int [] dir : direction) {
            int next_x = i + dir[0];
            int next_y = j + dir[1];

            if((next_x >= 0 && next_x<R) && (next_y >= 0 && next_y < C)) { // 범위 내에 있을 때
                // 그게 만약 바다라면 cnt증가
                if(grid[next_x][next_y] == '.') {
                    cnt++;
                }
            } else { // 범위 내에 없을 때
                cnt++;
            }
        }

        // cnt가 3 미만이면 true로 -> 50년 후에도 살아남는 땅
        if(cnt < 3) {
            visited[i][j] = true;
        } else { // 3이상이면 50년 후에는 가라앉을 땅
            visited[i][j] = false;
        }
    }


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        grid = new char [R][C];
        // 잠길 것으로 판단할 척도
        visited = new boolean[R][C];

        // 현재 지도 입력
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                grid[i][j] = str.charAt(j);
            }
        }


        // 잠길것인지 아닐지 판단
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(grid[i][j] == 'X') { // 만약 땅이라면
                    changeSea(i, j, R, C);
                }
            }
        }

        HashSet<Integer> xs = new HashSet<>();
        HashSet<Integer> ys = new HashSet<>();

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(visited[i][j] == true) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }

        List<Integer> findX = new ArrayList<>(xs);
        List<Integer> findY = new ArrayList<>(ys);

        Collections.sort(findX);
        Collections.sort(findY);

        int startX = findX.get(0);
        int endX = findX.get(findX.size()-1);
        int startY = findY.get(0);
        int endY = findY.get(findY.size()-1);



        for(int i=startX; i<=endX; i++) {
            for(int j=startY; j<=endY; j++) {
                if(visited[i][j] == true) System.out.print('X');
                else System.out.print('.');
            }
            System.out.println();
        }





    }
}
