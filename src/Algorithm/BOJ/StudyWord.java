package Algorithm.BOJ;
import java.io.*;
import java.util.*;


public class StudyWord {
    public static void solution(char[] strArr) {
        int [] alpha = new int [26];
        for(char ch : strArr) {
            if(65<=(int)ch && (int)ch<=90) {
                alpha[(int)ch-65]++;
            } else if(97<=(int)ch && (int)ch <=122) {
                alpha[(int)ch-97]++;
            }
        }

        int ck = 1;
        int max =0;//빈도수 비교
        int index = 0; // 빈도수가 큰 알파벳의 인덱스 넣기

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<alpha.length; i++){
            if(alpha[i]>0) {
                if(max<alpha[i]) {
                    ck = 1;
                    max = alpha[i];
                    index = i;
                } else if(max == alpha[i]) ck++;
            }
        }

        if(ck == 1) System.out.println((char)(index+65));
        else System.out.println("?");
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        solution(str.toCharArray());


    }
}
