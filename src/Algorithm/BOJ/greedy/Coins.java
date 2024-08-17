package Algorithm.BOJ.greedy;

import java.util.*;
import java.io.*;

public class Coins {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] coins = new int [n];
        for(int i=0; i<n; i++) coins[i] = Integer.parseInt(br.readLine());

        int index = n-1;
        int count = 0;

        while(k!=0) {
            if(coins[coins.length - 1] < k) {
                count += k / coins[coins.length -1];
                k = k % coins[coins.length -1];
            } else {
                if(coins[index] == k) {
                    count += k / coins[index];
                    k = k % coins[index];
                } else if(coins[index] < k) {
                    count += k / coins[index];
                    k = k % coins[index];
                }
                index--;
            }
        }

        System.out.println(count);
    }
}