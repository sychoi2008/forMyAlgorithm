package Algorithm.BOJ.dp;

import java.util.*;
import java.io.*;

public class MakeOne {
    static int [] memo;
    static int dp(int n) {
        if(n == 1) {
            memo[n] = 0;
            return memo[n];
        }

        if(memo[n] == -1) {
            if(n%2 == 0 && n%3 == 0) {
                memo[n] = Math.min(Math.min(dp(n/3), dp(n/2))+1, dp(n-1)+1);
            } else if(n%2 == 0 && n%3 != 0) {
                memo[n] = Math.min(dp(n/2)+1, dp(n-1)+1);
            } else if(n%2 != 0 && n%3 == 0) {
                memo[n] = Math.min(dp(n/3)+1, dp(n-1)+1);
            } else {
                memo[n] = dp(n-1)+1;
            }
        }

        return memo[n];

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int [N+1];
        Arrays.fill(memo, -1);
        System.out.println(dp(N));
    }
}