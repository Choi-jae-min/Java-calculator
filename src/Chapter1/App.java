package Chapter1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("첫 번째 양의 정수를 입력하세요.");
        int a = input.nextInt();

        if (a < 0) {
            throw new ArithmeticException("양의 정수만 입력 할 수 있습니다 입력값 " + a +"는 음수입니다.");
        }
        System.out.println("첫 번째 양의 정수:" + a);

        System.out.println("두 번째 양의 정수를 입력하세요.");
        int b = input.nextInt();

        if (b < 0) {
            throw new ArithmeticException("양의 정수만 입력 할 수 있습니다 입력값 " + b +"는 음수입니다.");
        }
        System.out.println("두 번째 양의 정수:" + b);

    }
}
