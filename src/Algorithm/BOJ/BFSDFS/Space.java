package Algorithm.BOJ.BFSDFS;

import java.util.*;
import java.io.*;


public class Space
{
    static int M;
    static int N;
    static int square = 0;
    static List<Integer> size = new ArrayList<>();
    static int [][] grid;
    static boolean [][] visited;

    static void bfs(int x, int y) {
        int [][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
        int s = 1;

        Queue<Spot2> queue = new LinkedList<>();
        queue.offer(new Spot2(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Spot2 cur = queue.poll();
            for(int [] dir : direction) {
                int n_x = cur.x + dir[0];
                int n_y = cur.y + dir[1];

                if(isInRange(n_x, n_y) && !visited[n_x][n_y] && grid[n_x][n_y] == 0) {
                    queue.offer(new Spot2(n_x, n_y));
                    visited[n_x][n_y] = true;
                    s++;
                }
            }

        }
        square++;
        size.add(s);
    }

    static boolean isInRange(int x, int y) {
        return (x>=0 && x<M) && (y>=0 && y<N);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        grid = new int [M][N];
        visited = new boolean[M][N];

        while(K!=0) {
            K--;
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());

            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for(int y=ly; y<ry; y++) {
                for(int x=lx; x<rx; x++) {
                    grid[y][x] = 1;

                }
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);

                }
            }
        }

        System.out.println(square);
        Collections.sort(size);
        for(int cnt : size) {
            System.out.print(cnt+ " ");
        }



    }
}

class Spot2 {
    int x;
    int y;
    Spot2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}