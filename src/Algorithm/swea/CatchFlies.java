package Algorithm.swea;

import java.util.*;
import java.io.*;

public class CatchFlies
{
    static int N;
    static int M;
    static int maxValue;
    static int [][] grid;

    static void catchFly() {
        int [][] plus = new int [N][N];


        // 가로로 길이를 M씩 묶어서 더하기
        for(int i=0; i<N; i++){
            for(int j=0; j<=N-M; j++) {
                for(int x=j; x<j+M; x++) {
                    plus[i][j] += grid[i][x];
                }
            }
        }

        // 큰 값 찾기
        // 현재 행 + M씩 더해보면서 큰 값 찾기
        for(int i=0; i<=N-M; i++) {
            for(int j=0; j<=N-M; j++) {
                int total = 0;
                for(int x=i;x<i+M; x++) {
                    total += plus[x][j];
                }
                maxValue = Math.max(maxValue, total);

            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            grid = new int[N][N];
            //grid 넣기
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int x=0; x<N; x++) {
                    grid[j][x] = Integer.parseInt(st.nextToken());
                }
            }

            catchFly();
            System.out.println("#"+i+" "+maxValue);
            maxValue = 0;
        }
    }
}