package Algorithm.BOJ.implementation;

import java.util.*;
import java.io.*;

public class Day8Ex2 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++) {
            hm.put(br.readLine(), i);
        }

        int [] ys = new int [N];

        for(int i=0; i<N; i++) {
            ys[i] = hm.get(br.readLine());
        }

        int cnt = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(ys[i] > ys[j]) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);



    }



}
