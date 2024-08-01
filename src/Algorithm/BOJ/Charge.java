package Algorithm.BOJ;

import java.util.*;
import java.io.*;


public class Charge {
    public static int solution(int charge) {
        if (charge % 5 == 0) return charge / 5;
        else {
            if ((charge % 5) % 2 == 0) {
                int temp = charge / 5;
                int nokori = (charge % 5) / 2;
                return temp + nokori;
            } else {
                if (((charge / 5 - 1) != -1) && (charge - ((charge / 5 - 1) * 5)) % 2 == 0) {
                    int res = charge / 5 - 1;
                    int na = (charge - ((charge / 5 - 1) * 5)) / 2;
                    return res + na;
                } else return -1;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int charge = Integer.parseInt(br.readLine());

        System.out.println(solution(charge));
    }

}