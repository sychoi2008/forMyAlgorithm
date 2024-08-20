package Algorithm.Programmers;

public class TargetNumber {
    static int result = 0;
    static void getResult(int sum, int idx, int [] numbers, int target) {

        if(idx == numbers.length) {
            if(sum == target) {
                result++;
                return;
            }
            return;
        }

        getResult(sum+numbers[idx], idx+1, numbers, target);
        getResult(sum-numbers[idx], idx+1, numbers, target);




    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        getResult(0, 0, numbers, target);
        answer = result;
        return answer;
    }
}
