package Algorithm.BOJ.dp;

import java.util.*;
import java.io.*;

public class LDS
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int [] memo = new int [N];
        Arrays.fill(memo, 1); // 모두 자신으로 시작되는 하나의 수열

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] < arr[j]) { // 가장 끝에 있는 i보다 더 큰 수를 발견
                    // 현재 값 VS 이전의 수열 길이 + 나를 포함
                    // i번째 숫자를 수열의 마지막 숫자라고 할 때,
                    // 앞에서 얻을 수 있는 수열의 최대 길이를 갱신

                    // ex) 30 - 20으로 20은 이미 30을 포함하여 수열의 길이를 계산했기 때문에
                    // 30 - 20 - 10에서 10이 마지막 숫자가 되었을 때, 20의 수열에서 1을 더하기만 하면 됨
                    memo[i] = Math.max(memo[i], memo[j]+1);
                }
            }
        }

        Arrays.sort(memo);
        System.out.println(memo[N-1]);
    }
}