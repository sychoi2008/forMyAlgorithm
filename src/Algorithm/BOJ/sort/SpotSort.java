package Algorithm.BOJ.sort;

import java.util.*;
import java.io.*;
public class SpotSort {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Spot> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Spot(x, y));
        }

        Collections.sort(list, new Comparator<Spot>() {
            @Override
            public int compare(Spot s1, Spot s2) {
                if(s1.y == s2.y) {
                    return s1.x - s2.x;
                } else {
                    return s1.y - s2.y;
                }
            }
        });

        for(int j=0; j<N; j++) {
            Spot cur = list.get(j);
            System.out.println(cur.x + " " + cur.y);
        }

    }

    static class Spot {
        int x;
        int y;
        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}