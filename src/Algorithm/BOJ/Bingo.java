package Algorithm.BOJ;

import java.util.*;
import java.io.*;

public class Bingo {
    static class Bin {
        int num;
        boolean ck;
        public Bin(int num, boolean ck) {
            this.num = num;
            this.ck = ck;
        }
    }

    public static void deleteNum(Bin [][] go, int num) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(go[i][j].num == num) {
                    go[i][j].ck = true;
                    return;
                }
            }
        }
    }

    public static int crossCheckL(Bin [][] go) {
        int crossCkL = 0;
        // 왼쪽 위-> 오른쪽 아래래
        for(int i=0; i<5; i++) {
            if(go[i][i].ck == true) {
                crossCkL++;
            } else if(go[i][i].ck == false) break;
        }

        if(crossCkL == 5) return 1;
        else return 0;
    }

    public static int crossCheckR(Bin [][] go) {
        int crossCkR = 0;
        // 오른쪽 위 -> 왼쪽 아래
        for(int j=0; j<5; j++) {
            if(j==0){
                if(go[j][4].ck == true) crossCkR++;
            } else if(j==1) {
                if(go[j][3].ck == true) crossCkR++;
            } else if(j==2) {
                if(go[j][2].ck == true) crossCkR++;
            } else if(j==3) {
                if(go[j][1].ck == true) crossCkR++;
            } else if(j==4) {
                if(go[j][0].ck == true) crossCkR++;
            }
        }

        if(crossCkR == 5) return 1;
        else return 0;
    }

    public static int garoCheck(Bin [][] go) {
        int ck = 0;
        int garo = 0; // 가로 빙고 수 세기
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(go[i][j].ck == true) ck++;
                else if(go[i][j].ck == false) {
                    ck = 0;
                    break;
                }
            }
            if(ck == 5) {
                garo++;
                ck=0;
            }
        }

        return garo;

    }

    public static int seroCheck(Bin [][] go) {
        int ck = 0;
        int sero = 0; // 세로 빙고 수 세기
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(go[j][i].ck == true) ck++;
                else if(go[j][i].ck == false) {
                    ck = 0;
                    break;
                }
            }
            if(ck == 5) {
                sero++;
                ck=0;
            }
        }

        return sero;
    }

    public static Bin [][] go = new Bin[5][5];

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            for(int j=0; j<5; j++) {
                go[i][j] = new Bin(Integer.parseInt(st.nextToken()), false);
            }
        }


        int cnt = 0;
        for(int x=0; x<5; x++) {
            String call = br.readLine();
            StringTokenizer st1 = new StringTokenizer(call);
            int result = 0;
            for(int l=0; l<5; l++) {
                deleteNum(go, Integer.parseInt(st1.nextToken()));
                cnt++;
                // 대각선, 가로, 세로 체크한 메소드의 개수를 총 더해서 3개가 나오면 바로 break걸고 나오기
                result += crossCheckL(go);
                result += crossCheckR(go);
                result += garoCheck(go);
                result += seroCheck(go);
                if(result >= 3) break;
                result = 0;
            }
            if(result >=3) {
                System.out.println(cnt);
                break;
            }
        }



    }
}