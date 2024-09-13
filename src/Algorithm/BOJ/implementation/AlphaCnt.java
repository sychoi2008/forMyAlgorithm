package Algorithm.BOJ.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class AlphaCnt {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int [] alphaArr = new int[26];
        for(int i = 0; i< alphaArr.length; i++) {
            alphaArr[i] = 0;
        }

        for(int alpha : str.toCharArray()) {
            alphaArr[alpha - 97] += 1;
        }

        for(int num : alphaArr) {
            System.out.print(num+" ");
        }
    }

}
