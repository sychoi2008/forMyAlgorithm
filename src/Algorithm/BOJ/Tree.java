package Algorithm.BOJ;

import java.util.*;
import java.io.*;

public class Tree {
    static String answer;
    static char [][] video;

    public static boolean checkAllSame(int r, int c, int size) {// r:시작 행
        char temp = video[r][c];
        for(int i=r; i<r+size; i++) {
            for(int j=c; j<c+size; j++) {
                if(temp != video[i][j]) return false;
            }
        }

        return true;
    }


    public static void solution(int r, int c, int size) {
        if(checkAllSame(r,c,size)) {
            answer = answer+video[r][c];
        } else {
            answer += "(";
            solution(r,c,size/2);
            solution(r,c+size/2, size/2);
            solution(r+size/2, c, size/2);
            solution(r+size/2, c+size/2, size/2);
            answer+=")";
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        video = new char [len][len];
        answer = "";

        for(int i=0; i<len; i++) {
            char [] temp = br.readLine().toCharArray();
            for(int j=0; j<len; j++) {
                video[i][j] = temp[j];
            }
        }

        solution(0,0,len);
        System.out.println(answer);

    }
}