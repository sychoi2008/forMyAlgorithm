package Algorithm.BOJ.BFSDFS;

import java.util.*;
import java.io.*;

public class Maze {
    static int N;
    static int M;
    static char [][] grid;
    static boolean [][] visited;

    static boolean isInRange(int x, int y) {
        return (x>=0 && x<N) && (y>=0 && y<M);
    }

    static int bfs() {
        int steps = 0; // 최종 리턴
        int [][] direction = {{-1,0},{0,1},{1,0},{0,-1}};

        Queue<Spot> queue = new LinkedList<>();
        queue.offer(new Spot(0,0,1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Spot cur = queue.poll();
            int cX = cur.x;
            int cY = cur.y;
            if(cX == N-1 && cY == M-1) {
                steps = cur.step;
                break;
            }
            for(int [] dir : direction) {
                int nX = cX + dir[0];
                int nY = cY + dir[1];
                if(isInRange(nX, nY) && grid[nX][nY] == '1' && !visited[nX][nY]) {
                    queue.offer(new Spot(nX, nY, cur.step+1));
                    visited[nX][nY] = true;
                }
            }

        }

        return steps;

    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());





    }
}

class Spot {
    int x;
    int y;
    int step;
    Spot(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}