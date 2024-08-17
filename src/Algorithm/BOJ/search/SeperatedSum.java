package Algorithm.BOJ.search;

import java.util.*;
import java.io.*;

public class SeperatedSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i=1; i<=n; i++) {
            int number = i;
            int temp = 0;

            while(number>0) {
                temp = temp + number % 10;
                number = number / 10;
            }

            if(temp + i == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);


    }
}
