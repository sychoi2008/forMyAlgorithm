package Algorithm;

import java.util.Stack;

public class Brackets {

    static boolean checkBrackets(String s) {
        //static을 쓰지 않고 함수 안에서 사용하자.
        Stack<Character> stack = new Stack<>();
        for(char b : s.toCharArray()) {
            if (b == '(') stack.push(')');
            else if(b == '[') stack.push(']');
            else if(b == '{') stack.push('}');
            /* else { 이 과정을 또 다른 else if문으로 만들어서 사용해야 함
                char temp = stack.peek();
                if(b == temp) stack.pop();
                else return false;
            } */
            else if(!stack.isEmpty() && stack.peek() == b) {
                // 스택이 비어있지 않고, 가장 위에 있는 값이 지금 검사하는 값과 같다면
                // 이 조건문에 맞지 위배되는 경우는 '([)]'와 같은 경우임
                stack.pop();
            } else { // 스택이 비어있지 않은데 알맞지 않은 닫힌 괄호가 들어왔을 때 예를 들어, '(]'
                // 또는 ')('처럼 닫힌 괄호가 먼저 나왔을 때 스택이 비어있으므로
                return false;
            }
        }
        // for문을 다 돌아서 빠져나온 후 스택이 비어있으면
        // 괄호 잘 닫은 것 = true;

        // for문을 다 돌고 나서 스택이 비어있지 않음
        // = 괄호 다 못닫음 = false; '()[' 이런 경우
        // 즉, input이 홀수개로 들어오면 false를 반환함
        return stack.empty();
    }
    public static void main(String[] args) {
        System.out.println(checkBrackets("{[]}"));
    }
}
