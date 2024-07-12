package Algorithm.Personal;

public class isThisPrime {
    public static boolean checkPrime(int num) {
        // 소수라면 true, 아니라면 false;
        boolean check = true;
        // 소수의 특성을 고려하여 for문의 조건을 만듦
        // 소수 : 약수가 1과 자기 자신 뿐. 따라서 for문을 1과 자기 자신을 제외한 수 사이에서
        // 돌려서 그 값들과 나누었을 때, 나누어지지 않는다면 소수. 나누어 떨어진다면 소수 아님
        // 이 특성을 이용
        for(int i=2; i<num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        if(checkPrime(998)) System.out.println("소수");
        else System.out.println("소수 아님");

    }
}
