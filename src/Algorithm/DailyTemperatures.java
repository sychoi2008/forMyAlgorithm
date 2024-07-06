package Algorithm;

import java.util.Stack;

public class DailyTemperatures {
    static class tempItem {
        int cur_day;
        int cur_temp;

        public tempItem(int cur_day, int cur_temp) {
            this.cur_day = cur_day;
            this.cur_temp = cur_temp;
        }
    }


    public static int [] solved(int[] temp) {
        int [] answer = new int[temp.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< temp.length; i++) {
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int day = stack.pop();
                answer[day] = i - day;
            }
            stack.push(i);

        }

        return answer;
    }


    public static void main(String[] args) {
        int [] temperatures = {30,40,50,60};
        for(int num : solved(temperatures)) {
            System.out.print(num+" ");
        }
    }
}
