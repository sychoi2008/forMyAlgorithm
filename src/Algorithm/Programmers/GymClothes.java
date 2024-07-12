package Algorithm.Programmers;

import java.util.*;
public class GymClothes {
    public static int solution(int n, int[] lost, int[] reserve) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        int [] clothesCnt = new int[n];
        // 체육복 개수 초기화
        for(int i=0; i< clothesCnt.length; i++) {
            hm.put(i+1, true); // hm 초기화
            clothesCnt[i] = 1; // 체육복 개수 초기화
        }


        Arrays.sort(lost);
        Arrays.sort(reserve);


        for(int num : lost) { //lost에 번호 있는 체육복들은 0으로 바꾸기
            hm.put(num, false);
            clothesCnt[num-1] = 0;
        }


        for(int res : reserve) {
            clothesCnt[res-1]++; //여벌이 있으면 1추가
            hm.put(res, true);

            if(hm.get(res)==true) {
                if((res-1) > 0 && clothesCnt[res-1] >=2 && hm.get(res-1) == false ) hm.put(res-1, true);
                else if((res+1)<=n && clothesCnt[res-1] >=2 && hm.get(res+1) == false) hm.put(res+1, true);
            } else if(hm.get(res) == false) hm.put(res,true);
        }

        int answer = 0;
        for(int x=1; x<=n; x++) {
            if(hm.get(x) == true) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{4,5}, new int[]{3,4}));
    }
}
