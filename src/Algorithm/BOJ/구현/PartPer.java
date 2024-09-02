package Algorithm.BOJ.구현;

import java.util.*;
import java.io.*;

public class PartPer {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        hm.put(A, 1);

        int find = 0; // 중복이 시작되는 값 넣을 변수
        int index = 2;
        while(true) {
            int next = 0; // P번 곱해서 더할 변수
            while(A!=0) {
                next += (int)Math.pow(A%10, P);
                A = A/10;
            }
            A = next;


            if(hm.containsKey(next)){
                //System.out.println(next);
                find = next;
                break;
            } else {
                hm.put(next, index);
                index++;
            }
        }


        System.out.println(hm.get(find)-1);

    }
}