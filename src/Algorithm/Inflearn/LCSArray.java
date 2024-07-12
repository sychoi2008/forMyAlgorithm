package Algorithm.Inflearn;

import java.util.*;

public class LCSArray {
    public static int solution (int [] nums) {
        int longest = 0;
        Set<Integer> hs = new HashSet<>(); // 중복 제거를 위해 set으로 선정
        for(int num : nums) hs.add(num);

        for(int num : nums) {
            if(hs.contains(num-1)) { // 시작점인지 확인
                int cnt = 1; // 시작점에 있으므로 1로 시작
                int target = num + 1; // 연속 숫자
                while(hs.contains(target)) { // hs안에 다음 숫자가 있을동안 반복
                    cnt++; // 연속된 길이를 세주기
                    target++; // 그 다음 숫자
                }
                // while문을 빠져나왔다는 얘기는 연속된 숫자인 target이 없다는 소리
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int []{0,3,7,2,5,8,4,6,0,1}));
    }
}
