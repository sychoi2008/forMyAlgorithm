package Algorithm.swea;

import java.util.*;
import java.io.*;

public class PrintSC
{
    static int N;
    static int [][] grid;

    static boolean isInRange(int x, int y) {
        return (x>=0 && x<N) && (y>=0 && y<N);
    }

    static void snail() {
        int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int num = 1;
        int cX = 0;
        int cY = 0;
        int d = 0;

        while(d<4) {
            grid[cX][cY] = num;
            //System.out.println("뭐임?" + num);
            num++;
            if(num > N*N) break;

            int nX = cX + dir[d][0];
            int nY = cY + dir[d][1];

            if(!isInRange(nX, nY) || grid[nX][nY] != 0) {
                if(d+1 > 3) d = 0;
                else d++;

                cX = cX + dir[d][0];
                cY = cY + dir[d][1];
                continue;
            } else if(isInRange(nX, nY) && grid[nX][nY] == 0) {
                cX = nX;
                cY = nY;
                continue;
            }
        }
    }

    static void printSnail(int idx){
        System.out.println("#"+idx);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            N = Integer.parseInt(br.readLine());
            grid = new int [N][N];
            snail();
            printSnail(i);
        }
    }
}