package Algorithm.Programmers;

import java.util.HashMap;

public class Replace {
    // Let's compare replace and replaceAll method
    public static String solution(String new_id) {

        //1단계 : 대문자 -> 소문자 치환
        String answer = new_id.toLowerCase();

        //2단계
        //(1) -,_,.,a-z(소문자),0-9(숫자)를 제외한 모든 문자가 제거됨
        answer = answer.replaceAll("[^-_.a-z0-9]","");

        //3단계
         answer = answer.replace("..",".");
         while(answer.contains("..")) {
             answer = answer.replace("..", ".");
         }
        // replaceAll의 정규식 표현으로 한번에 제거 가능
        // .이 연속으로 2번 이상 오면 .으로 치환하기
        //answer = answer.replaceAll("[.]{2,}",".");

        //4단계
         if(answer.length() > 0) {
             if(answer.charAt(0)=='.') answer = answer.substring(1);
         }
         if(answer.length() > 0) {
             if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
         }
        //replaceAll 정규표현식으로 간단히 표현 가능
        //^x -> 문자열이 x로 시작, x$ -> 문자열이 x로 끝남
        //| : or 연산자
        //answer = answer.replaceAll("^[.]|[.]$", "");


        if(answer.equals("")) {
            answer += "a";
        }

        if(answer.length() >= 16) {
            // 문자열에서 15개만 가져오기
            answer = answer.substring(0,15);
            //if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
            answer = answer.replaceAll("[.]$","");
        }

        if(answer.length() <= 2) {
            char last = answer.charAt(answer.length()-1);
            while(answer.length()<3) {
                answer+=last;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
