package Algorithm.BOJ;

import java.util.*;
import java.io.*;

public class Ropes {
    static int max_value = 0;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rope = Integer.parseInt(br.readLine());

        int [] ropes = new int[rope];

        for(int i=0; i<rope; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int repeat = ropes.length;

        for(int i=0; i<ropes.length; i++) {
            int temp = ropes[i];

            int sum = 0;
            for(int j=0; j<repeat; j++) {
                sum += temp;
            }

            max_value = Math.max(sum, max_value);
            repeat--;
        }

        System.out.println(max_value);
    }
}
