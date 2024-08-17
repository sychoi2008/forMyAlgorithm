package Algorithm.BOJ.sort;

import java.util.*;
import java.io.*;


public class SerialNum {
    public static int numSum(String str) {
        String temp = str;

        temp = temp.replaceAll("[A-Z]", "");

        if(temp.equals("")) return 0;
        else {
            int strSum = 0;
            for(char ch : temp.toCharArray()) {
                strSum += Integer.parseInt(String.valueOf(ch));
            }
            return strSum;
        }

    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];

        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if(str1.length() == str2.length()) {
                    int str1Sum = numSum(str1);
                    int str2Sum = numSum(str2);

                    if(str1Sum == str2Sum) {
                        return str1.compareTo(str2);
                    } else {
                        return str1Sum - str2Sum;
                    }



                } else {
                    return str1.length() - str2.length();
                }
            }
        });


        for(String strPrint : arr) {
            System.out.println(strPrint);
        }

    }


}