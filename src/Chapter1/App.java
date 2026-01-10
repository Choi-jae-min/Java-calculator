package Chapter1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String isExitString = "";
        int result;
        Scanner input = new Scanner(System.in);

        while (!isExitString.equals("exit")) {

            System.out.println("첫 번째 양의 정수를 입력하세요.");
            int positiveNumber1 = input.nextInt();

            if (positiveNumber1 < 0) {
                throw new IllegalArgumentException("양의 정수만 입력 할 수 있습니다 입력값 " + positiveNumber1 +"는 음수입니다.");
            }
            System.out.println("첫 번째 양의 정수:" + positiveNumber1);

            System.out.println("두 번째 양의 정수를 입력하세요.");
            int positiveNumber2 = input.nextInt();

            if (positiveNumber2 < 0) {
                throw new IllegalArgumentException("양의 정수만 입력 할 수 있습니다 입력값 " + positiveNumber2 +"는 음수입니다.");
            }
            System.out.println("두 번째 양의 정수:" + positiveNumber2);
            System.out.println("사칙연산 기호를 입력하세요 + , - , * , / ");

            char operator = input.next().charAt(0);
            System.out.println("입력 받은 사칙연산:" + operator);

            result = switch (operator) {
                case '+' -> positiveNumber1 + positiveNumber2;
                case '-' -> positiveNumber1 - positiveNumber2;
                case '*' -> positiveNumber1 * positiveNumber2;
                case '/' -> {
                    if (positiveNumber2 == 0) {
                        throw new ArithmeticException("0으로는 나눌 수 없습니다.");
                    }
                    yield positiveNumber1 / positiveNumber2;
                }
                default -> throw new IllegalArgumentException("올바른 사칙연산 기호를 입력하세요 현재 입력값 : " + operator);
            };
            System.out.println("결과 : " + result);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            isExitString = input.next();
        }
    }
}
