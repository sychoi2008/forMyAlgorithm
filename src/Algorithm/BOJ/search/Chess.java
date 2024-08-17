package Algorithm.BOJ.search;

import java.util.*;
import java.io.*;

public class Chess {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String [] chessBoard = new String[N]; // 한줄씩 받을 것

        for(int i=0; i<N; i++) {
            chessBoard[i] = br.readLine();
        }

        int count = Integer.MAX_VALUE; // 가장 큰 값으로 지정함

        for(int i=0; i<=N-8; i++) { // 행의 시작점. 이 값을 기준으로 8 증가해야하므로
            for(int j=0; j<=M-8; j++) { // 열의 시작점
                int resultCount = getMinCost(i, j, chessBoard);

                if(count > resultCount) {
                    count = resultCount;
                }
            }
        }

        System.out.println(count);
    }

    public static int getMinCost(int startRow, int startCol, String [] chessBoard) {
        String [] board = {"WBWBWBWB", "BWBWBWBW"};

        int whiteVerCount = 0; // 제일 좌측 상단이 흰색으로 시작되는 보드판을 만들 것

        for(int i=0; i<8; i++) {
            int row = startRow + i; // i를 더하는 이유는 실제 인덱스 값을 알기 위해서
            for(int j=0; j<8; j++) {
                int col = startCol + j;

                if(chessBoard[row].charAt(col) != board[row%2].charAt(j)) {
                    whiteVerCount++; // 흰색 시작 보드판을 기준으로 바꿔야 할 부분을 센다.
                }
            }


        }
        return Math.min(whiteVerCount, 64-whiteVerCount);
    }
}