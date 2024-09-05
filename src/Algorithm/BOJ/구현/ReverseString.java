package Algorithm.BOJ.구현;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class ReverseString {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int end = i+1;

            if(str.charAt(i) == '<') {
                while(true) {
                    if(str.charAt(i) == '>') {
                        sb.append(str.charAt(i));
                        break;
                    } else {
                        sb.append(str.charAt(i));
                        i++;
                    }
                }
            } else if(str.charAt(i) == ' ') {
                sb.append(' ');
            }else {
                while(true) {
                    if(end == str.length()) break;
                    else if(str.charAt(end) == '<') break;
                    else if(str.charAt(end) == ' ') break;
                    end++;
                }

                for(int j=end-1; j>=i; j--) sb.append(str.charAt(j));
                i=end-1;


            }

        }
        System.out.print(sb);


    }
}
