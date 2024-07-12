package Algorithm.BOJ;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ReverseBascket {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bucketNum = Integer.parseInt(st.nextToken());
        int reverseCnt = Integer.parseInt(st.nextToken());

        int [] bucket = new int [bucketNum];
        for(int i=0; i<bucketNum; i++) {
            bucket[i] = i+1;
        }

        for(int x=0; x<reverseCnt; x++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int gap = j-i;
            while(gap>0) {
                int temp = bucket[i-1];
                bucket[i-1] = bucket[(i-1)+gap];
                bucket[(i-1)+gap] = temp;
                i++;
                gap-=2;
            }
        }
        for(int num : bucket) {
            System.out.print(num+" ");
        }
    }
}
