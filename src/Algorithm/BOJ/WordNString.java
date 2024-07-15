package Algorithm.BOJ;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class WordNString {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = Integer.parseInt(br.readLine());
        char [] strArr = str.toCharArray();

        System.out.println(strArr[cnt-1]);

    }
}
