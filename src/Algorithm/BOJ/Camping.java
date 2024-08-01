package Algorithm.BOJ;

import java.util.*;
import java.io.*;
public class Camping {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;

        while(true) {
            String str = br.readLine();
            if(str.equals("0 0 0")) break;

            StringTokenizer st = new StringTokenizer(str);
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());


            int day = (V/P)*L+Math.min(L,(V%P));


            System.out.println("Case "+index+": "+day);
            index++;
        }
    }
}
