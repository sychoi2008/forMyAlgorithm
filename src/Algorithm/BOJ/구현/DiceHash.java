package Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DiceHash {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        StringTokenizer st = new StringTokenizer(str1);

        // 주사위 3개를 넣을 배열
        int nums[] = new int[3];

        // 배열에 각각 넣어준다.
        nums[0] = Integer.parseInt(st.nextToken());
        nums[1] = Integer.parseInt(st.nextToken());
        nums[2] = Integer.parseInt(st.nextToken());

        // 해쉬맵을 사용하여 풀이
        HashMap<Integer, Integer> hm = new HashMap<>();

        // 같은 것을 셀 cnt 변수
        int check = 1;
        // 같은 수가 뭔지 넣을 변수
        int same = 0;
        // 최종 상금 가격을 계산해서 출력할 변수
        int result = 0;


        for(int j=0; j<nums.length; j++) {
            if(hm.containsKey(nums[j])) { //containsKey메소드를 사용하여 중복 계산
                check++;
                same = nums[j];
            } else {
                hm.put(nums[j], j);
            }
        }

        if(check == 3) result = same * 1000 + 10000;
        else if(check==2) result = same * 100 + 1000;
        else {
            Arrays.sort(nums);
            result = nums[nums.length - 1] * 100;
        }

        System.out.println(result);
    }
}
