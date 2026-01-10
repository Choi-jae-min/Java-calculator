package Chapter2;

import java.util.ArrayList;

public class Calculator {

    // 래퍼 클래스가 아닌 진짜 컬랙션 타입 생성
    ArrayList<Integer> calculateResult = new ArrayList<>();

    int CalculateNumber(int positiveNumber1, int positiveNumber2 , char operator) {
        if (positiveNumber1 < 0 || positiveNumber2 < 0) {
            throw new IllegalArgumentException("양의 정수만 입력 할 수 있습니다 첫번째 입력값" + positiveNumber1 + ", 두번째 입력값" +positiveNumber2);
        }
        // 변수에 저장 하지 않고 오직 계산 결과만 반환 하도록 변경 , 저장은 다른 매서드로.
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
}
