package Algorithm.Personal;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyBag {
    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    // 그리디 알고리즘을 이용한 분할 가능 배낭 문제 해결
    static double getMaxValue(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];

        // 물건 배열 초기화
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        // 단위 무게당 가치가 높은 순서로 정렬
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> (double) item.value / item.weight).reversed());

        double totalValue = 0.0; // 총 가치 초기화
        int currentWeight = 0; // 현재 배낭에 담긴 무게 초기화

        // 정렬된 순서대로 아이템을 담기
        for (Item item : items) {
            // 현재 물건을 담을 수 있는 무게를 계산
            int remainingWeight = capacity - currentWeight;

            // 물건 전체를 담을 수 있는 경우
            if (remainingWeight >= item.weight) {
                totalValue += item.value;
                currentWeight += item.weight;
            } else { // 일부분만 담을 수 있는 경우
                totalValue += item.value * ((double) remainingWeight / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] weights = {10,8,25,60};
        int[] values = {100,120,1000,120};
        int capacity = 40;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("최대 가치: " + maxValue);
    }
}
