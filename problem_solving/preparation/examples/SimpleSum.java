import java.util.Scanner;

/**
 * 접근 순서
 * 1. 사용자 입력을 어떻게 받는가?
 * 2. 입력받은 값들을 더한 결과를 어떻게 표시하는가?
 */

class SimpleSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A + B);
    }
}