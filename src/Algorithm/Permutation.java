package Algorithm;

import java.util.ArrayList;

public class Permutation {
    public static int [] arr;
    public static boolean [] visited;
    public static int [] selected;
    public static int pCount;

    public static void perm(int cnt, int pickNum) {
        if(cnt == pickNum) {
            pCount++;
            for(int i=0; i< selected.length; i++) {
                System.out.print(selected[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<arr.length; i++) {
            //visited를 통해 중복을 허용하지 않음. 예를 들면 113 <- 이런식
            if(!visited[i]) {
                visited[i] = true;
                selected[cnt] = arr[i];
                perm(cnt+1, pickNum);
                // 하지만 재귀함수를 빠져나오면 cnt-1로 예를 들어 selected의 마지막 값을 다 한번씩 탐색하고 다시 1번째 인덱스(selected의 두번째 값)으로 돌아갔을 때
                // 다시 또 숫자들을 돌려야 하기 때문에 false 처리를 해준다.
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int pickNum = 3;
        arr = new int []{1,2,3,4,5,6};
        // arr와 같은 길이의 boolean 타입의 배열
        visited = new boolean[arr.length];
        selected = new int[pickNum];
        pCount = 0;
        perm(0, pickNum);
        System.out.println("순열의 개수 : " + pCount);

    }
}
