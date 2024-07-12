package Algorithm.Personal;

public class Combination {
    static int [] arr;
    static int pickNum;
    static int [] selected;
    static int pCom;
    public static void comb(int cnt, int start) {

        if(cnt == pickNum) {
            pCom++;
            for(int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<arr.length; i++) {
            selected[cnt] = arr[i];
            // cnt = selected의 인덱스. 따라서 재귀함수 호출 시 다음 인덱스로 진출하는 것이기에 +1
            // i+1을 해주는 이유는, arr[i]가 이미 cnt에 들어갔기 때문에 cnt+1자리에는 arr[i]의 다음 값인 arr[i+1]부터 들어가야함 -> 중복이 없어야 하므로
            // selected가 다 채워지면 재귀함수를 벗어남 -> selected의 마지막 index를 바꿔주는 작업 또 시작 -> 다 바꿔줬으면 cnt-1인 함수로 내려가서 for문의 조건에 의해 i+1
            // 된 값을 cnt-1 자리에 넣고 또 반복.

            // 조합이 앞에 자리 부터 반복하지 않고 i+1부터 하는 이유는 또 한가지 더 있음
            // 앞에서 부터 해버리면 다음과 같은 중복이 또 발생함 예를 들면 123은 이미 출력을 했는데 312 와 같은 중복이 발생하기도 함
            comb(cnt+1, i+1);
        }

    }
    public static void main(String[] args) {
        arr = new int []{1,2,3,4,5,6};
        pickNum = 3;
        pCom = 0;
        selected = new int [pickNum];
        comb(0,0);
        System.out.println("조합 개수 : "+pCom);

    }
}
