package Algorithm.BOJ.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OvenTime {
    public class Main {
        public static void solution(int a, int b, int c) {
            int real_m = 0;
            int real_h = 0;

            if(c > 59) {
                int h = c/60;
                int m = c%60;

                if(b+m > 59) {
                    real_m = (b+m) % 60;
                    int hour_left = (b+m) / 60;
                    if(hour_left + h + a > 23) real_h = (hour_left + h + a) % 23 -1;
                    else real_h = hour_left + h + a;
                } else {
                    real_m = b+m;
                    if(h+a > 23) real_h = (h+a) % 23 -1;
                    else real_h = h+a;
                }
            } else {
                if(b+c > 59) {
                    real_m = (b+c) % 60;
                    int hour_left = (b+c)/60;
                    if(hour_left+a > 23) real_h = (hour_left + a) %23 -1;
                    else real_h = hour_left + a;
                } else {
                    real_m = b+c;
                    real_h = a;
                }
            }
            System.out.println(real_h + " "+ real_m);
        }


        public static void main (String args[]) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str1 = br.readLine();
            String str2 = br.readLine();

            StringTokenizer st = new StringTokenizer(str1);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(str2);

            solution(a,b,c);

        }
    }
}
