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
            if(!visited[i]) {
                visited[i] = true;
                selected[cnt] = arr[i];
                perm(cnt+1, pickNum);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int pickNum = 3;
        arr = new int []{1,2,3,4,5,6};
        visited = new boolean[arr.length];
        selected = new int[pickNum];
        pCount = 0;
        perm(0, pickNum);
        System.out.println("순열의 개수 : " + pCount);

    }
}
