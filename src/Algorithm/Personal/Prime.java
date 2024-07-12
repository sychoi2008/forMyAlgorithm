package Algorithm.Personal;

public class Prime {
    public static boolean [] primeArr;
    public static void printPrime(int target) {
        // 0~target 까지의 인덱스를 만들기 위해서 target+1을 한다
        primeArr = new boolean [target+1];

        // 배열의 모든 값을 true 로 초기화
        // 소수라면 true, 아니라면 false를 가질 것
        for(int i=0; i< primeArr.length; i++) primeArr[i] = true;

        // 0, 1은 소수에서 제외
        primeArr[0] = false;
        primeArr[1] = false;

        int sn = (int)Math.sqrt(target);

        // target의 제곱근까지만 돌려도 소수 판별 가능
        for(int i=2; i<=sn; i++) {
            // j를 증가시키는 값으로 생각할 수도 있고 index 자체로도 생각할 수 있음
            // 여기서는 인덱스 자체로 생각해서 풀이함. 시작은 i*2 부터 시작하여 i*1은 생각 X.
            // 즉, 자기자신은 포함하지 않고 건너뛰고 소수를 지워나가는 것
//            for(int j=i*2; j< primeArr.length; j+=i) {
//                // j들은 다 소수가 아닌 값들이므로 false를 처리한다.
//                primeArr[j] = false;
//            }


            //또는 다음과 같이 j값을 설정할 수 있다.
            for(int j=2; j*i<primeArr.length; j++) {
                primeArr[i*j] = false;
            }

        }

//        System.out.println(target+" 이하의 소수 목록");
//        for(int index = 2; index<primeArr.length; index++) {
//            if(primeArr[index] == true) System.out.print(index + " ");
//        }


    }

    public static void printResult(int num, int [] nums) {
        int result = 0;
        for(int i=0; i<num; i++) {
            if(primeArr[nums[i]]) result++;
        }

        System.out.println("몇 개 일까? : "+result);
    }


    public static void main(String args[]) {
        printPrime(1000);
        printResult(4, new int []{1,3,5,7});
    }
}
