package Chapter1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("첫 번째 양의 정수를 입력하세요.");
        int a = input.nextInt();
        System.out.println("첫 번째 양의 정수:" + a);

        System.out.println("두 번째 양의 정수를 입력하세요.");
        int b = input.nextInt();
        System.out.println("두 번째 양의 정수:" + b);
    }
}
