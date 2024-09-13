package Algorithm.BOJ.implementation;

import java.util.*;
import java.io.*;

public class Line {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] height = new int [N];
        for(int i=0; i<N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(N);

        for(int i=N-2; i>=0; i--) {
            if(height[i] == 0) ll.add(0, i+1);
            else {
                int index = 0;
                for(int j=0; j<height[i]; j++) index++;
                ll.add(index, i+1);
            }
        }

        for(int i=0; i<ll.size(); i++) {
            System.out.print(ll.get(i)+" ");
        }


    }
}