package Algorithm.BOJ.implementation;

import java.io.*;

public class Snail {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int [][] table = new int [N][N];
        //Arrays.fill(table, -1);

        int curX = 0;
        int curY = 0;
        int dir = 0;

        // 처음은 0,0 = N^2부터 시작.
        table[curX][curY] = N*N;

        // 반시계 방향으로 접근할 것이기에 남(0(여기서 이 인덱스는 dx, dy의 인덱스!)), 동(1), 북(2), 서(3)
        // ex) 남쪽이면 행이 1증가!
        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, 1, 0, -1};

        while(dir<4) {
            int nX = curX + dx[dir];
            int nY = curY + dy[dir];

            if((nX>=0 && nX<N && nY>=0 && nY<N) && table[nX][nY] == 0) {
                table[nX][nY] = table[curX][curY] - 1;

                if(table[nX][nY] == 1) break;

                curX = nX;
                curY = nY;

            } else { // 범위를 벗어났거나 값이 -1이 아닌 경우
                dir++;
            }

            if(dir >= 4) dir = 0;
        }

        int tarX = 0;
        int tarY = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(table[i][j] + " ");
                if(table[i][j] == target) {
                    tarX = i+1;
                    tarY = j+1;
                }
            }
            System.out.println();
        }

        System.out.println(tarX + " "+ tarY);

    }
}