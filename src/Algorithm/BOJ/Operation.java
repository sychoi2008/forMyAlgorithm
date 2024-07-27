package Algorithm.BOJ;
import java.io.*;
import java.util.*;


public class Operation {
    static int [] numbers; // 숫자를 넣을 배열
    static int [] operations; // 연산자 개수를 넣을 배열
    static int numCnt; // 숫자 개수
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    static void solution(int num, int index) { // 1번째 : 왼쪽 수, 2번째 : num 다음 수(numbers 배열의 인덱스 값)
       // base case 설정
        if(index == numCnt) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
            return;
        }

        for(int i=0; i<4; i++) {
            if(operations[i]>0) {
                operations[i]--;

                switch (i) {
                    case 0:
                        solution(num + numbers[index], index+1);
                        break;
                    case 1 :
                        solution(num - numbers[index], index+1);
                        break;
                    case 2 :
                        solution(num * numbers[index], index+1);
                        break;
                    case 3:
                        solution(num / numbers[index], index+1);
                }

                operations[i]++;
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numCnt = Integer.parseInt(br.readLine());

        // 숫자 넣기
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int [numCnt];
        for(int i=0; i<numCnt; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // operation 개수 넣기
        st = new StringTokenizer(br.readLine());
        operations = new int [4];
        for(int i=0; i<4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        solution(numbers[0],1);

        System.out.println(maxNum);
        System.out.println(minNum);


    }
}
