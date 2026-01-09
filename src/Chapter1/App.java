package Chapter1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int result;
        Scanner input = new Scanner(System.in);

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

//        switch를 채용한 이유, 위와 같은 동작을 기대 할 수있는 if문 코드는 아래 같은 형식이라 생각이 드는데.
//        이런 형태로 4개의 if , 혹은 else if문은 가독성을 떨어뜨리고, 만약 같은 if문이 해당 기능 외에도 20개 30 개 가있다고 생각하면,
//        어디까지가 사칙연산을 위한 if문으로 어디가 다른 기능을 위한 if인지 알기 어렵다고 생각했습니다.
//        거기에 마지막 default 를 활용하여 해당 모든 조건에 만족하지 않는다면, 이외에는 무조건 에러라고 판단 할 수 있기에 채용하였습니다.
        switch (operator) {
            case '+':
                result = positiveNumber1 + positiveNumber2;
                break;
            case '-':
                result = positiveNumber1 - positiveNumber2;
                break;
            case '*':
                result = positiveNumber1 * positiveNumber2;
                break;
            case '/':
                if (positiveNumber2 == 0) {
                    throw new ArithmeticException("0으로는 나눌 수 없습니다.");
                }
                result = positiveNumber1 / positiveNumber2;
                break;
            default:
                throw new IllegalArgumentException("올바른 사칙연산 기호를 입력하세요 현재 입력값 : " + operator);
        }
        System.out.println("결과 : " + result);
    }
}
