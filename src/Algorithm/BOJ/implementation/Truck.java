package Algorithm.BOJ.implementation;
import java.io.*;
import java.util.*;

public class Truck {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String feeStr = br.readLine();
        StringTokenizer st = new StringTokenizer(feeStr);

        // 시간 타임라인
        int [] carTime = new int [101];

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int min = 100; int max = 0;

        for(int i=0; i<3; i++) {
            String time_str = br.readLine();
            st = new StringTokenizer(time_str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(min>start) min = start;
            if(max<end) max = end;

            for(int j = start; j<=end; j++) { //j에 등호가 들어가는가?
                carTime[j]++;
            }
        }

        System.out.println(min);
        System.out.println(max);
        int result = 0;
        for(int x=min; x<=max; x++) {
            if(carTime[x] == 1) result += a * 1;
            else if(carTime[x] == 2) result += b * 2;
            else result += carTime[x] * 3;
        }
        System.out.println(result);

    }
}
