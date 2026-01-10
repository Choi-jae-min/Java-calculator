package Chapter2;

import java.util.ArrayList;

public class Calculator {

    ArrayList<Integer> calculateResult = new ArrayList<>();

    int CalculateNumber(int positiveNumber1, int positiveNumber2 , char operator) {
        return switch (operator) {
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
    }
    // 정수 유효성 검사 로직 분리
    void isValidNumber(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("양의 정수만 입력 할 수 있습니다 입력값 " + number + "는 음수입니다.");
        }
    }
}
