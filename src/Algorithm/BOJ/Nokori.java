package Algorithm.BOJ;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Nokori {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] nokori = new int[10];

        for(int i=0; i<10; i++) {
            int num = Integer.parseInt(br.readLine());
            nokori[i] = num % 42;
        }

        Arrays.sort(nokori);

        int count = 1;
        for(int j=0; j<10; j++) {
            if(j==0) continue;
            else {
                if(nokori[j] != nokori[j-1]) count++;
            }
        }

        System.out.println(count);
    }
}
