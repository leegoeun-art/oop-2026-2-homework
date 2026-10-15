import java.util.Scanner;

public class Homework4 {
    // 재귀호출을 이용한 최대공약수 (나머지 연산 이용)
    static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        if (m < n) {
            return gcd(m, n % m);   // m이 작은 수: n을 m으로 나눈 나머지
        } else {
            return gcd(n, m % n);   // n이 작은 수: m을 n으로 나눈 나머지
        }
    }

    // 반복문을 이용한 최대공약수 (같은 알고리즘)
    static int gcdLoop(int m, int n) {
        while (n != 0) {
            int small;
            int big;
            if (m < n) { small = m; big = n; }
            else { small = n; big = m; }
            m = small;
            n = big % small;
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("두 수를 입력하세요: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("두 수의 최대공약수는 " + gcd(a, b) + "입니다.");
        // 반복문 버전: System.out.println("두 수의 최대공약수는 " + gcdLoop(a, b) + "입니다.");
    }
}
