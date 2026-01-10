package Challenge;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> calculateResult = new ArrayList<>();

    int CalculateNumber(int positiveNumber1, int positiveNumber2 , OperatorType operator) {
        return switch (operator) {
            case OperatorType.PLUS -> positiveNumber1 + positiveNumber2;
            case OperatorType.MINUS -> positiveNumber1 - positiveNumber2;
            case OperatorType.MULTIPLY -> positiveNumber1 * positiveNumber2;
            case OperatorType.DIVIDE -> {
                if (positiveNumber2 == 0) {
                    throw new ArithmeticException("0으로는 나눌 수 없습니다.");
                }
                yield positiveNumber1 / positiveNumber2;
            }
        };
    }
    // 정수 유효성 검사 로직 분리
    void checkValidNumber(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("양의 정수만 입력 할 수 있습니다 입력값 " + number + "는 음수입니다.");
        }
    }

//    public void setCalculateResult(ArrayList<Integer> calculateResult) {
//        this.calculateResult = calculateResult;
//    }

    public ArrayList<Integer> getCalculateResult() {
        return calculateResult;
    }

    public void addCalculateResult(int number) {
        this.calculateResult.add(number);
    }

    public void removeFristCalculateResult() {
        this.calculateResult.removeFirst();
        System.out.println("삭제 후 결과 : " + this.calculateResult);
    }
}
