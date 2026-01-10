package Chapter2;

public class Calculator {

    // 컬랙션 타입 Integer 생성.
    Integer calculateResult;

    // Chapter1 에서 사용한 향상된 switch (lamda) 를 사용하여 두 양의 정수를 매개변수로 받아 사칙 연산을 진행하는 매서드 작성.
    int CalculateNumber(int positiveNumber1, int positiveNumber2 , char operator) {

        // 양의 정수만 입력 받을 수 있도록 변경
        if (positiveNumber1 < 0 || positiveNumber2 < 0) {
            throw new IllegalArgumentException("양의 정수만 입력 할 수 있습니다 첫번째 입력값" + positiveNumber1 + ", 두번째 입력값" +positiveNumber2);
        }

        this.calculateResult = switch (operator) {
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

        return calculateResult;
    }

}
