package Algorithm.Programmers;

import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String str : skill_trees) {
            str = str.replaceAll("[^"+skill+"]", "");

            boolean check = true;
            for(int i=0; i<str.length(); i++) {
                if(skill.charAt(i) != str.charAt(i)) {
                    check = false;
                    break;
                }
            }
            if(check == true) answer++;
        }
        return answer;
    }
}