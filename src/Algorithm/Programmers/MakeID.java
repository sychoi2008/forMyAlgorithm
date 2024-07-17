package Algorithm.Programmers;

import java.util.LinkedList;

public class MakeID {
    public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");


        new_id = new_id.replace("..", ".");
        while(new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        if(new_id.length() > 0) {
            if(new_id.charAt(0) == '.') new_id = new_id.substring(1,new_id.length());
        }
        if(new_id.length() > 0) {
            if(new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0,new_id.length()-1);
        }

        if(new_id.length() == 0) {
            new_id = new_id+"a";
        }

        if(new_id.length() >= 16) {
            new_id = new_id.substring(0,15); // 15개의 문자를 제외한 나머지는 삭제이므로 마지막 인덱스는 14이다. 따라서 15
            if(new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0,new_id.length()-1);
        }

        StringBuilder sb = new StringBuilder(new_id);
        if (new_id.length() <= 2) {
            char last = new_id.charAt(new_id.length()-1);
            while(sb.length() < 3) {
                sb.append(last);
            }
        }

        answer = String.valueOf(sb);

        return answer;

    }

    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
