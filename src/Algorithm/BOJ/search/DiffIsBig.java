package Algorithm.BOJ.search;

import java.util.*;
import java.io.*;

public class DiffIsBig
{
    static int [] original;
    static boolean [] visited;
    static int [] temp;
    static int num;

    static int max_value = Integer.MIN_VALUE;

    public static void getResult() {
        int res =  0;

        for(int i=0; i<num-1; i++) {
            res = res + Math.abs(temp[i]-temp[i+1]);
        }

        max_value = Math.max(max_value, res);
    }

    public static void changeNum (int index) {
        if(index == num) {
            getResult();
            return;
        }

        for(int i=0; i<num; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[index] = original[i];
                changeNum(index+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        original = new int [num];
        visited = new boolean [num];
        temp = new int [num];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        for(int i=0; i<num; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        changeNum(0);

        System.out.println(max_value);
    }
}
