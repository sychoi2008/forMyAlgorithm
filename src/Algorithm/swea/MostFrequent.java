package Algorithm.swea;

import java.util.*;
import java.io.*;

public class MostFrequent
{
    static int maxScore;
    static int maxValue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            int caseNum = Integer.parseInt(br.readLine());
            maxScore = 0;
            maxValue = 0;
            HashMap<Integer, Integer> hm = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<1000; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(!hm.containsKey(temp)) hm.put(temp, 1);
                else hm.put(temp, hm.getOrDefault(temp, 1)+1);
            }

            for(int s : hm.keySet()) {
                if(maxValue < hm.get(s)) {
                    maxValue = hm.get(s);
                    maxScore = s;
                } else if(maxValue == hm.get(s)) maxScore = Math.max(s, maxScore);
            }
            System.out.println("#"+caseNum+" "+maxScore);
        }

    }
}