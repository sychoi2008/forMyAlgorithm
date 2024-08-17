package Algorithm.BOJ.sort;

import java.util.*;
import java.io.*;

public class WordSort {
    static String [] words;
    public static void quickSort(int start, int end) {
        if(start>= end) return;


        int pivot = start;
        int i = start+1;
        int j = end;
        String temp = "";

        while(i<=j) {
            while(i<=end && words[i].length()<= words[pivot].length()) i++;
            while(j>start && words[j].length()>=words[pivot].length()) j--;

            if(i>j) {
                temp = words[j];
                words[j] = words[pivot];
                words[pivot] = temp;
            } else {
                temp = words[i];
                words[i] = words[j];
                words[j] = temp;
            }
        }
        quickSort(start, j-1);
        quickSort(j+1, end);
    }


    public static void printArr() {
        for(String str : words) {
            System.out.println(str);
        }
    }


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        words = new String[N];

        for(int i=0; i<N; i++) {
            words[i] = br.readLine();

        }

        quickSort(0, N-1);
        printArr();
    }


}

