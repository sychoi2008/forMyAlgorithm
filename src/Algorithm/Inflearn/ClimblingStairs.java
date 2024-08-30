package Algorithm.Inflearn;

import java.util.*;

class Solution {
    public int climbStairs(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(memo, n);
    }
    public int dp(int [] memo, int n){
        if(n==0 || n==1) return 1; // 만약 2층까지 가야 한다고 했을 때, 0층에서 2계단 점프. 1층에서 1계단 점프. 총 2개

            // 1층, 2층에 올라가는 방법을 구해서 해도 됨
            // if (n==1) return 1;
            // else if(n == 2) return 2;

        else if(memo[n] == -1) { // 재귀함수를 이용한 top-down방식
            memo[n] = dp(memo, n-1) + dp(memo, n-2); // 5층을 올라가는 방법 = 4층에서 1계단 점프+3층에서 2계단 점프
        }
        return memo[n];
    }
}
