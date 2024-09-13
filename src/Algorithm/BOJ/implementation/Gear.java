package Algorithm.BOJ.implementation;

import java.util.*;
import java.io.*;

public class Gear {
    static boolean [] visited;
    static char [] gear1;
    static char [] gear2;
    static char [] gear3;
    static char [] gear4;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[5];
        gear1 = new char [8];
        gear2 = new char [8];
        gear3 = new char [8];
        gear4 = new char [8];

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        String str4 = br.readLine();

        // 톱니바퀴 S, N 넣어주기
        for(int i=0; i<8; i++) gear1[i] = str1.charAt(i);
        for(int i=0; i<8; i++) gear2[i] = str2.charAt(i);
        for(int i=0; i<8; i++) gear3[i] = str3.charAt(i);
        for(int i=0; i<8; i++) gear4[i] = str4.charAt(i);

        // 돌릴 횟수
        int K = Integer.parseInt(br.readLine());
        while(K != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 톱니 번호
            int gearNum = Integer.parseInt(st.nextToken());
            // 돌릴 방향(1 -> 시계방향(true), -1 -> 반시계방향(false))
            boolean turnDir = st.nextToken().equals("1") ? true : false;
            //System.out.println(gear3[2] + " " + gear3[6]);
            change(gearNum, turnDir);

            K--;
        }

        System.out.println(getResult());

    }

    static void change(int gear, boolean dir) { // 톱니 번호, 돌릴 방향
        if(gear == 1) { // 1번 톱니
            visited[1] = true; // 이미 돌렸다는 표시
            int cross = gear1[2]; // 2번 톱니와 맞물리는 곳

            // 톱니 돌리기
            gear1 = trun(gear1, dir);

            // 점진적으로 돌리기 = 재귀적인 호출
            // 두번째 톱니가 1번 톱니와 상극이면서 아직 돌려지지 않은 톱니라면? 두번째 톱니도 돌리기
            if(gear2[6] != cross && !visited[2]) change(2, !dir);
            visited[1] = false;

        } else if(gear == 2) {
            visited[2] = true;

            int leftCross = gear2[6];
            int rightCross = gear2[2];

            gear2 = trun(gear2, dir);


            if(!visited[1] && gear1[2] != leftCross) change(1, !dir);
            if(!visited[3] && gear3[6] != rightCross) change(3, !dir);

            visited[2] = false;
        } else if(gear == 3) {
            visited[3] = true;

            int leftCross = gear3[6];
            int rightCross = gear3[2];

            gear3 = trun(gear3, dir);


            if(!visited[2] && gear2[2] != leftCross) change(2, !dir);
            if(!visited[4] && gear4[6] != rightCross) change(4, !dir);

            visited[3] = false;
        } else if(gear == 4) {
            visited[4] = true;
            int cross = gear4[6];

            gear4 = trun(gear4, dir);

            if(gear3[2] != cross && !visited[3]) change(3, !dir);
            visited[4] = false;
        }

    }

    static char[] trun(char [] gear, boolean dir) {
        char [] temp = new char[8]; // 돌린 결과를 넣을 임시 배열
        if(dir) { // 시계 방향
            temp[0] = gear[7];
            for(int i=1; i<8; i++) temp[i] = gear[i-1];
        } else {
            temp[7] = gear[0];
            for(int i=0; i<7; i++) temp[i] = gear[i+1];
        }


        return temp;
    }

    static int getResult() {
        int total = 0;
        if(gear1[0] == '1') total+= 1;
        if(gear2[0] == '1') total+= 2;
        if(gear3[0] == '1') total+= 4;
        if(gear4[0] == '1') total+= 8;

        return total;
    }
}