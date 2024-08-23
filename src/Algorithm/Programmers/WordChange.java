package Algorithm.Programmers;

import java.util.*;

class WordChange {
    static int min_value = Integer.MAX_VALUE;
    static boolean [] visited;
    static int diffCnt(String str1, String str2) {

        int cnt = 0;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) cnt++;
        }

        return cnt;
    }
    static void getResult(String [] words, int idx, String begin, int change, String target) {

        for(int i=0; i<words.length; i++) {
            if(!visited[i] && diffCnt(begin, words[i]) == 1) {

                if(words[i].equals(target)) {
                    min_value = Math.min(min_value, change);
                    return;
                }
                visited[i] = true;
                getResult(words, idx+1, words[i], change+1, target);
                visited[i] = false;

            }
        }
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean chk = false;
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(target)) {
                chk = true;
                break;
            }
        }
        if(chk == false) return 0;
        else {
            visited = new boolean [words.length];
            getResult(words, 0, begin, 1, target);
            return min_value;
        }

    }
}