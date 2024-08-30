package Algorithm.Inflearn;

import java.util.*;

class MinCostStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; // 꼭대기
        int [] memo = new int [n+1]; // 꼭대기도 포함하기 때문에
        Arrays.fill(memo, -1);
        return dp(memo, cost, n);
    }

    public int dp(int [] memo, int [] cost, int n) { // n층 까지 가는 가격의 합
        if(n == 0 || n == 1) return 0; // 0층, 1층까지 오는 가격은 0
        else if (memo[n] == -1) { // 아직 메모이제이션을 하지 않았다면
            // n층까지 오는 것은 n-1층에서 1점프 or n-2층에서 2점프
            // n-1층에서 1점프를 할 시, n-1층의 가격도 더해서 올라와야 함(n-2층도 마찬가지)
            memo[n] = Math.min(dp(memo, cost, n-1)+cost[n-1], dp(memo, cost, n-2)+cost[n-2]);
        }
        return memo[n];
    }
}
