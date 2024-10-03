package Algorithm.swea;


import java.util.*;
import java.io.*;

public class WordTest
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean [][] grid = new boolean[N][N];

            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int x=0; x<N; x++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp == 0) grid[j][x] = false;
                    else grid[j][x] = true;
                }
            }


            int answer = 0;
            // 행
            for(int j=0; j<N; j++) {
                int row_len = 0;
                //boolean flag = false;
                int x = 0;
                for(x=0; x<N; x++) {
                    if(grid[j][x]) {
                        row_len++;
                    }
                    else {
                        if(row_len == K) answer++;
                        row_len = 0;
                    }
                }
                if(x == N && row_len == K) answer++;

            }
            //System.out.println("중간 answer"+answer);


            // 열
            for(int j=0; j<N; j++) {
                int col_len = 0;
                int x=0;
                for(x=0; x<N; x++) {
                    if(grid[x][j]) col_len++;
                    else {
                        if(col_len == K) answer++;
                        col_len = 0;
                    }
                }
                if(x == N && col_len == K) answer++;
            }

            System.out.println("#"+i+" "+answer);
        }
    }
}

