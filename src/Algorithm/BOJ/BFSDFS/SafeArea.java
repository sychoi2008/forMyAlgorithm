package Algorithm.BOJ.BFSDFS;

import java.util.*;
import java.io.*;

public class SafeArea
{
    static int N;
    static int [][] grid;
    static boolean [][] visited;

    static int max_value = 0;
    static int max_area = 0;

    static boolean isInRange(int x, int y) {
        return (x>=0 && x<N) && (y>=0 && y<N);
    }

    static void bfs(int i, int j, int a) {
        Queue<Spot3> queue = new LinkedList<>();
        queue.offer(new Spot3(i, j));
        visited[i][j] = true;

        int [][] direction = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        while(!queue.isEmpty()) {
            Spot3 cur = queue.poll();
            for(int [] dir : direction) {
                int n_x = cur.x+dir[0];
                int n_y = cur.y+dir[1];

                if(isInRange(n_x, n_y) && !visited[n_x][n_y] && grid[n_x][n_y]>a) {
                    queue.offer(new Spot3(n_x, n_y));
                    visited[n_x][n_y] = true;

                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //System.out.println(N);

        grid = new int [N][N];
        visited = new boolean [N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                max_value = Math.max(temp, max_value);
                grid[i][j] = temp;
            }
        }



        for(int a = 2; a<=max_value; a++) {
            int area = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(grid[i][j] > a && !visited[i][j]) {
                        bfs(i, j, a);
                        area++;
                    }
                }
            }
            max_area = Math.max(max_area, area);
            Arrays.fill(visited, false);
        }

        System.out.println(max_area);
    }
}

class Spot3 {
    int x;
    int y;

    Spot3(int x, int y){
        this.x = x;
        this.y = y;
    }
}
