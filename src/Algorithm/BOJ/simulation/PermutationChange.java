package Algorithm.BOJ.simulation;

import java.util.*;
import java.io.*;

public class PermutationChange {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int printRange = N-K;

        int [] nums = new int [N];

        str = br.readLine();
        st = new StringTokenizer(str,",");

        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int len = nums.length - 1;

        while(K!=0) {
            for(int i=1; i<=len; i++) {
                nums[i-1] = nums[i] - nums[i-1];
            }
            K--;
            len--;
        }

        for(int i=0; i<printRange; i++) {
            if(i==printRange-1) System.out.print(nums[i]);
            else System.out.print(nums[i]+",");

        }

    }
}
