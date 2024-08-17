package Algorithm.BOJ.search;

import java.util.*;

class Shortest {
    boolean isInRange(int r, int c, int rowLength, int colLength) {
        return (r>=0 && r<rowLength) && (c>=0 && c<colLength);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int shortestDist = -1;

        int row = grid.length;
        int col = grid[0].length;

        if(grid[0][0] != 0 || grid[row-1][col-1] != 0) return shortestDist;


        boolean [][] visited = new boolean[row][col];
        int [][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};

        //초기셋팅
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int [] curPos = queue.poll();
            int curRow = curPos[0];
            int curCol = curPos[1];
            int curLength = curPos[2];

            if(curRow == row-1 && curCol == col-1) {
                shortestDist = curLength;
                return shortestDist;
            }

            for(int [] d : dir) {
                int nextRow = curRow + d[0];
                int nextCol = curCol + d[1];
                if(isInRange(nextRow, nextCol, row, col)) {
                    if(grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                        queue.offer(new int[]{nextRow, nextCol, curLength+1});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return shortestDist;
    }

}
