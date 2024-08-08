package Algorithm.BOJ;

import java.util.*;
import java.io.*;
public class PermutationPart
{
    static int [] nums;
    static int N;
    static int S;
    static int count;

    public static void solution(int sum, int index) {
        // base case. 부분수열이 최장이 될 경우. 모든 숫자를 다 사용할 경우이므로
        if(index == N) return;

        // 일단 더해보기
        sum += nums[index];

        // 같다면 증가
        if(sum == S) count++;

        // 현재 숫자를 포함하여 다시 진단
        solution(sum, index+1);

        // 현재 숫자를 제외하고 다시 진단
        sum-=nums[index];
        solution(sum, index+1);

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        count = 0;

        String numbers = br.readLine();
        st = new StringTokenizer(numbers);
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solution(0,0);
        System.out.println(count);
    }
}