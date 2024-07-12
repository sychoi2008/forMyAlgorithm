package Algorithm.Personal;

import java.util.Arrays;
import java.util.Collections;

public class GreedyEX {
    static int findMinimumCoins(int charge, int [] coins) {
        int coinsNum = 0;
        for(int i=0; i<coins.length; i++) {
            coinsNum = coinsNum + charge / coins[i];
            // 나눗셈을 통해 값을 갱신
            charge = charge % coins[i];
        }
        return coinsNum;

    }

    public static void main(String[] args) {
        int charge = 8750;
        int [] coins = {500,100,50,10};

        int coinsCount = findMinimumCoins(charge, coins);
        System.out.println("동전 개수 : "+ coinsCount);


    }
}
