package Algorithm.BOJ;

import java.util.*;
import java.io.*;

public class Ball {
    static int [] nums;
    public static void swap(int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        nums = new int[4];
        for(int i=1; i<nums.length; i++) {
            nums[i] = i;
        }

        int X = 0;
        int Y = 0;

        String str;
        StringTokenizer st;

        while(M!=0) {
            str = br.readLine();
            st = new StringTokenizer(str);

            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            swap(X, Y);
            M--;

        }

        int res = -1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == 1) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}