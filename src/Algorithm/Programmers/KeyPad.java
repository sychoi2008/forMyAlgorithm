package Algorithm.Programmers;

import java.util.*;

class KeyPad {
    public String solution(int[] numbers, String hand) {
        int lT = 10;
        int rT = 12;
        String answer = "";


        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                lT = num;
                answer += "L";
            } else if(num == 3 || num == 6 || num == 9) {
                rT = num;
                answer += "R";
            } else {
                if(num == 0) num = 11;

                int lD = Math.abs(lT-num) / 3 + Math.abs(lT-num) % 3;
                int rD = Math.abs(rT-num) / 3 + Math.abs(rT-num) % 3;

                if(lD < rD) {
                    lT = num;
                    answer+="L";
                } else if(rD < lD) {
                    rT = num;
                    answer+="R";
                } else {
                    if(hand.equals("left")) {
                        lT = num;
                        answer+="L";
                    } else {
                        rT = num;
                        answer+="R";
                    }
                }
            }
        }
        return answer;
    }
}

