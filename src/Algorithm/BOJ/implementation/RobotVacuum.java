package Algorithm.BOJ.implementation;

//https://moonsbeen.tistory.com/12
import java.io.*;
import java.util.*;

public class RobotVacuum {
    static int N;
    static int M;
    static int count = 1;
    static int [][] direction = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int [][] grid;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 현재위치, 현재 방향
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());


        grid = new int [N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<M; j++) {
                int pixel = Integer.parseInt(st.nextToken());
                grid[i][j] = pixel;
            }
        }
        dfs(r, c, dir);
        System.out.println(count);

    }

    static void dfs(int r, int c, int dir) {
        grid[r][c] = -1;

        for(int i=0; i<4; i++) {
            dir -= 1;
            if(dir == -1) dir = 3;
            int n_r = r+direction[dir][0];
            int n_c = c+direction[dir][1];
            if(isInRange(n_r, n_c) && grid[n_r][n_c] == 0) {
                count++;
                dfs(n_r, n_c, dir);
                return;
            }
        }


        int d = (dir+2) % 4;
        int bR = r+direction[d][0];
        int bC = c+direction[d][1];
        if(isInRange(bR, bC) && grid[bR][bC] != 1) dfs(bR, bC, dir);


    }




    static boolean isInRange(int x, int y) {
        return ((x>=0 && x<N) && (y>=0 && y<M));
    }
}