package Algorithm.BOJ.search;

import java.io.*;

public class OneTwoThree {
    static int count;

    public static void solution(int res, int goal, int index) {
        if(res == goal) { // n과 같을 때 아닐까?
            count++;
            return;
        } else if(index > goal) {
            return;
        }

        for(int i = 1; i<=3; i++) {
            int temp = res + i;
            solution(temp, goal, index+1);
        }
    }


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(br.readLine());

        for(int i=0; i<repeat; i++) {
            count = 0;
            int num = Integer.parseInt(br.readLine());
            solution(0, num, 1);
            System.out.println(count);
        }
    }
}