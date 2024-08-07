package Algorithm.Inflearn;

import java.util.*;

public class NumberOfIslands {
    static boolean isInRange(int r, int c, int row_length, int col_length) {
        return ((r>=0 && r<row_length) && (c>=0 && c<col_length));
    }
    public static int numIslands(char[][] grid) { // 하나하나 bfs 돌리기 위한 함수
        int numberOfIslands = 0; // 섬의 개수를 넣을 변수
        int row_length = grid.length; // 행의 개수
        int col_length = grid[0].length; // 열의 개수
        boolean[][] visited = new boolean[row_length][col_length]; // grid와 똑같은 visited 배열

        for(int i=0; i<row_length; i++) {
            for(int j=0; j<col_length; j++) { // grid 하나하나를 돌면서 탐색 => 0,1인지 판별하기 위함
                if((grid[i][j] == '1') && (visited[i][j] == false)) { // 땅이면서 방문하지 않은 곳
                    bfs(i, j, grid, visited); // grid[i][j]에서 시작해서 그 주변을 다 탐색해라
                    numberOfIslands++; // bfs로 다 방문하고 빠져나왔으면은 섬 하나를 체크한 것
                }
            }
        }
        return numberOfIslands;
    }

    public static void bfs(int r, int c, char[][] grid, boolean[][] visited) {
        // 연결된 곳을 확인하기 위해 동서남북으로 가보기
        // 앞에서부터 위, 아래, 왼쪽, 오른쪽
        int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // grid의 행과 열의 길이 구하기
        int row_length = grid.length;
        int col_length = grid[0].length;

        //bfs 초기세팅
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(r,c)); // queue에다가 x,y를 넣어줌
        visited[r][c] = true; // 방문했다를 표시함

        // bfs 시작
        while(!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll(); // 현재 노드의 인덱스를 출력
            int cur_x = cur.getLeft(); // 현재 x 좌표
            int cur_y = cur.getRight(); // 현재 y 좌표

            // 현재노드에 연결된 노드들을 모두 방문하기 -> 현재 노드의 상하좌우 살펴보기
            // 원래 기본 bfs에서도 연결된 다음 노드로 가기 위해 for문을 돌렸음
            for(int [] d : dir) { //ex : {1,0}을 떼오는 것. 1차원 배열 떼오기
                int next_x = cur_x + d[0];
                int next_y = cur_y + d[1];

                if(isInRange(next_x, next_y, row_length, col_length)) {// grid의 범위를 넘으면 안됨
                    if(grid[next_x][next_y] == '1' && !(visited[next_x][next_y])) { // 육지여야 하고 visited 되어있지 않아야 함
                        visited[next_x][next_y] = true;
                        q.offer(new Pair<>(next_x, next_y));
                    }
                }
            }

        }
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }

    // 제너릭 클래스 사용
    static class Pair<L,R> {
        L left;
        R right;

        private Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return this.left;
        }

        public R getRight() {
            return this.right;
        }
    }
}
