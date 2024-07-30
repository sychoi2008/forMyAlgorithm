package Algorithm.Programmers;

import java.util.*;

public class Dolls {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int mov : moves) {
            for(int i=0; i<board.length; i++) {
                if(board[i][mov-1] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(board[i][mov-1]);
                        board[i][mov-1] = 0;
                        break;
                    } else if(stack.peek() == board[i][mov-1]) {
                        stack.pop();
                        board[i][mov-1] = 0;
                        answer+=2;
                        break;
                    } else {
                        stack.push(board[i][mov-1]);
                        board[i][mov-1] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String args[]) {
        //int [][] arr = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [][] arr = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 4, 4, 0}, {1, 2, 2, 1}};

        System.out.println(solution(arr, new int []{2,3,1,4,2,3}));
        HashMap<Integer, Boolean> hm = new HashMap<>();
    }
}
