package Algorithm.BOJ;

import java.util.*;
import java.io.*;

public class Eureka {
    static boolean flag = false;
    public static void solution(int res,int index,int goal) {
        if(index == 3) {
            if(res == goal) {
                flag = true;
                System.out.println(1);
                return;
            } else return;
        }

        for(int i=1; i<=goal; i++) {
            int temp = res + (i+(i+1))/2;
            solution(temp, index+1, goal);
            if(flag == true) break;
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCnt = Integer.parseInt(br.readLine());

        for(int i=0; i<numCnt; i++) {
            int num = Integer.parseInt(br.readLine());
            solution(0, 1, num);
            flag = false;
        }

    }

}
