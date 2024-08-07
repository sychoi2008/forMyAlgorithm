package Algorithm.BOJ;

import java.util.*;
import java.io.*;

public class JiminHansoo
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansoo = Integer.parseInt(st.nextToken());

        int round = 0;

        while(jimin != hansoo) {
            round++; // 대결 시작!

            // 대결 후 지민과 한수의 번호 초기화화
            jimin = (jimin/2) + (jimin%2);
            hansoo = (hansoo/2) + (hansoo%2);
        }
        System.out.println(round);
    }
}