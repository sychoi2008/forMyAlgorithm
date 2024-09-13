package Algorithm.BOJ.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Palindrome {
    public static int checkPop(char[] chArr) {
        Stack<Character> ch = new Stack<>();

        for(char chr : chArr) {
            ch.push(chr);
        }

        for(int i=0; i<chArr.length; i++) {
            if(chArr[i] != ch.pop()) return 0;
        }
        return 1;
    }

    public static void main (String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] chArr = str.toCharArray();
        System.out.println(checkPop(chArr));

    }
}
