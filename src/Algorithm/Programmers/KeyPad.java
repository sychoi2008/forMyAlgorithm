package Algorithm.Programmers;

import java.util.*;

class KeyPad {
    int [][] keyPad = {
            {3,1}, // 0
            {0,0}, // 1
            {0,1}, // 2
            {0,2}, // 3
            {1,0}, // 4
            {1,1}, // 5
            {1,2}, // 6
            {2,0}, // 7
            {2,1}, // 8
            {2,2} // 9
    };

    int [] leftPos = {3,0};
    int [] rightPos = {3,2};
    public String solution(int[] numbers, String hand) {
        String answer = "";

        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                answer += "L";
                leftPos = keyPad[num];
            } else if(num == 3 || num == 6 || num == 9) {
                answer += "R";
                rightPos = keyPad[num];
            } else {
                // 거리 계산
                int how_about_left = Math.abs(leftPos[0]-keyPad[num][0]) + Math.abs(leftPos[1]-keyPad[num][1]);
                int how_about_right = Math.abs(rightPos[0]-keyPad[num][0]) + Math.abs(rightPos[1]-keyPad[num][1]);
                if(how_about_left < how_about_right) {
                    answer+="L";
                    leftPos = keyPad[num];
                }
                else if(how_about_right < how_about_left) {
                    answer+= "R";
                    rightPos = keyPad[num];
                }
                else if(how_about_left == how_about_right) {
                    if(hand.equals("left")) {
                        answer+="L";
                        leftPos = keyPad[num];
                    }
                    else {
                        answer+= "R";
                        rightPos = keyPad[num];
                    }
                }
            }
        }


        return answer;
    }
}

