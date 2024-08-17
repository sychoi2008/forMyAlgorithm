package Algorithm.BOJ.greedy;

import java.util.*;
import java.io.*;
public class Water {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int spots = Integer.parseInt(st.nextToken());
        int tape = Integer.parseInt(st.nextToken());

        int [] spot = new int [spots];
        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<spots; i++) {
            spot[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(spot);

        int start = spot[0];
        int end = spot[0] + (tape-1);

        int answer = 1;

        for(int next : spot) {
            if(start<=next && next <= end) continue;
            else {
                start = next;
                end = next+(tape-1);
                answer++;
            }
        }
        System.out.println(answer);
    }
}